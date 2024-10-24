package pe.com.cibertec.LP2_EF_PalaciosJhosep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.UsuarioEntity;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.service.UsuarioService;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService = null;

    @GetMapping("/") 
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new UsuarioEntity(null, null, null, null, null, null)); 
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario,
                        Model model, HttpSession session) {
        boolean usuarioValidado = usuarioService.validarUsuario(usuarioFormulario);
        if (usuarioValidado) {
            session.setAttribute("usuario", usuarioFormulario.getCorreo());
            return "redirect:/productos";
        }

        model.addAttribute("loginInvalido", "No existe el usuario");
        model.addAttribute("usuario", new UsuarioEntity(null, null, null, null, null, null)); 
        return "login"; 
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioEntity(null, null, null, null, null, null)); 
        return "registro"; 
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuarioEntity,
                                   @RequestParam("foto") MultipartFile foto,
                                   Model model) {
 
        usuarioService.crearUsuario(usuarioEntity, foto);
        model.addAttribute("mensaje", "Usuario registrado con éxito.");
        return "redirect:/productos"; 
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/"; 
    }
}

