package pe.com.cibertec.LP2_EF_PalaciosJhosep.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.ProductoEntity;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.repository.ProductoRepository;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

	@Override
	public List<ProductoEntity> obtenerTodosLosProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}
}