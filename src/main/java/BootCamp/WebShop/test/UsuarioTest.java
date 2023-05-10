package BootCamp.WebShop.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.*;

import BootCamp.WebShop.model.Usuario;

public class UsuarioTest {

    @Test
    public void testGetNombreUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Juan");
        assertEquals("Juan", usuario.getNombreUsuario());
    }

    @Test
    public void testsetNombreUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Juan");
        assertEquals("Juan", usuario.getNombreUsuario());
    }
    

}