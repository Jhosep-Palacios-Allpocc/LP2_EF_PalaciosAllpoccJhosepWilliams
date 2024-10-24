package pe.com.cibertec.LP2_EF_PalaciosJhosep.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.UsuarioEntity;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.repository.UsuarioRepository;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.service.UsuarioService;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.utils.Utilitarios;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository = null;

    @Override
    public void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto) {

        String nombreFoto = Utilitarios.guardarImagen(foto);
        usuarioEntity.setUrlImagen(nombreFoto);

        String passwordHash = Utilitarios.extraerHash(usuarioEntity.getPassword());
        usuarioEntity.setPassword(passwordHash);

        usuarioRepository.save(usuarioEntity);
    }

    @Override
    public boolean validarUsuario(UsuarioEntity usuarioFormulario) {

        UsuarioEntity usuarioEncontrado = usuarioRepository.findByCorreo(usuarioFormulario.getCorreo());

        if (usuarioEncontrado == null) {
            return false;
        }

        if (!Utilitarios.checkPassword(usuarioFormulario.getPassword(), usuarioEncontrado.getPassword())) {
            return false; 
        }

        return true;
    }

    @Override
    public UsuarioEntity buscarUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
