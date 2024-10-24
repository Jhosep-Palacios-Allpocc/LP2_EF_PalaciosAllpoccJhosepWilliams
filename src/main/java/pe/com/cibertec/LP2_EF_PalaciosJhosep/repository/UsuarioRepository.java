package pe.com.cibertec.LP2_EF_PalaciosJhosep.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    UsuarioEntity findByCorreo(String correo);
}