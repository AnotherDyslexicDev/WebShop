package BootCamp.WebShop.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.service.UsuarioService;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value={"login","/login"})
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public ModelAndView loginForm(@ModelAttribute Usuario usuario, HttpSession session, @RequestParam(name = "rememberMe", required = false) boolean rememberMe) throws AuthenticationException {
        Usuario authUsuario = usuarioService.authenticate(usuario.getEmail(), usuario.getPassword());
        if (authUsuario != null) {
            if (rememberMe) {
                String token = generarToken();
                LocalDateTime expiration = LocalDateTime.now().plusDays(30);
                java.sql.Timestamp expirationDate = java.sql.Timestamp.valueOf(expiration);
                authUsuario.setToken(token);
                authUsuario.setSetExpirationDate(expirationDate);
                usuarioService.updateUsuario(authUsuario);
            }
            session.setAttribute("usuario", authUsuario);
            return new ModelAndView("redirect:/index");
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("error", "Email o contraseña incorrectos");
            modelAndView.setViewName("login");
            return modelAndView;	

        }
    }


    private String generarToken() {
        // Aquí puedes implementar tu propia lógica para generar un token único
        // Puedes utilizar librerías como java.util.UUID o SecureRandom para esto
        String token = UUID.randomUUID().toString();
        return token;
    }
}
