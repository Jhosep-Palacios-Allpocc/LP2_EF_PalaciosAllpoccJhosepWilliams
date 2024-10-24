package pe.com.cibertec.LP2_EF_PalaciosJhosep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
	    
}

