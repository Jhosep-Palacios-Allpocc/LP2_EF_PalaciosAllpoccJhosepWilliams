package pe.com.cibertec.LP2_EF_PalaciosJhosep.service;

import java.util.List;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.ProductoEntity;

public interface ProductoService {
    List<ProductoEntity> listarProductos();
    ProductoEntity buscarPorId(Integer id);
    ProductoEntity crearProducto(ProductoEntity producto);
    ProductoEntity actualizarProducto(ProductoEntity producto);
    void eliminarProducto(Integer id);
    List<ProductoEntity> obtenerTodosLosProductos();

}