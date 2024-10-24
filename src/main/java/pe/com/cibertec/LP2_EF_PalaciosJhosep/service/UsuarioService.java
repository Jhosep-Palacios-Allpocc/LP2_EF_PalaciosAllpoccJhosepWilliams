package pe.com.cibertec.LP2_EF_PalaciosJhosep.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.UsuarioEntity;

public interface UsuarioService {
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
    boolean validarUsuario(UsuarioEntity usuarioFormulario);
    UsuarioEntity buscarUsuarioPorCorreo(String correo);
}