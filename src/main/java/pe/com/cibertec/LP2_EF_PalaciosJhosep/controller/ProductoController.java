package pe.com.cibertec.LP2_EF_PalaciosJhosep.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.service.impl.PdfService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.com.cibertec.LP2_EF_PalaciosJhosep.model.ProductoEntity;
import pe.com.cibertec.LP2_EF_PalaciosJhosep.service.ProductoService;


@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private PdfService pdfService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<ProductoEntity> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "listarProductos";
    }

 
    @GetMapping("/productos/crear")
    public String crearProductoForm(Model model) {
        model.addAttribute("producto", new ProductoEntity(null, null, null, null, null));
        return "crearProducto"; 
    }


    @PostMapping("/productos/crear")
    public String crearProducto(@ModelAttribute ProductoEntity producto) {
        productoService.crearProducto(producto);
        return "redirect:/productos"; 
    }


    @GetMapping("/productos/editar/{id}")
    public String editarProductoForm(@PathVariable Integer id, Model model) {
        ProductoEntity producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "editarProducto"; 
    }

  
    @PostMapping("/productos/editar")
    public String actualizarProducto(@ModelAttribute ProductoEntity producto) {
        productoService.actualizarProducto(producto);
        return "redirect:/productos"; 
    }


    @GetMapping("/productos/{id}")
    public String detalleProducto(@PathVariable Integer id, Model model) {
        ProductoEntity producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "detalleProducto";
    }


    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos"; 
    }
    
    @GetMapping("/generarReporteProductos")
    public ResponseEntity<InputStreamResource> generarReporteProductos(@RequestParam String nombreUsuario) throws IOException {
        List<ProductoEntity> productos = productoService.obtenerTodosLosProductos(); 

        Map<String, Object> datos = new HashMap<>();
        datos.put("productos", productos);
        datos.put("nombre_usuario", nombreUsuario);

        ByteArrayInputStream pdf = pdfService.generarPdf("reporteProductos", datos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=reporte_productos.pdf");
        
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
