package BootCamp.WebShop.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/loginForm")
    public ModelAndView loginForm(@RequestBody Usuario usuario, HttpSession session, boolean rememberMe) {
        Usuario authUsuario = usuarioService.authenticate(usuario.getEmail(), usuario.getPassword());
        if (authUsuario != null) {
            if (rememberMe) {
                String token = generarToken();
                LocalDateTime expiration = LocalDateTime.now().plusDays(30);
                java.sql.Timestamp expirationDate  = java.sql.Timestamp.valueOf(expiration);
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
