package com.example.app.controller;
import com.example.app.dto.ProductoVentasDTO;
import com.example.app.dto.VentaRequest;
import com.example.app.model.Producto;
import com.example.app.model.Ubicacion;
import com.example.app.model.Venta;
import com.example.app.model.Persona;
import com.example.app.repository.ProductoRepository;
import com.example.app.repository.UbicacionRepository;
import com.example.app.repository.VentaRepository;
import com.example.app.repository.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaRepository ventaRepo;
    private final PersonaRepository personaRepo;
    private final ProductoRepository productoRepo;
    private final UbicacionRepository ubicacionRepo;
    public VentaController(VentaRepository ventaRepo, PersonaRepository personaRepo, ProductoRepository productoRepo, UbicacionRepository ubicacionRepo){
        this.ventaRepo=ventaRepo; this.personaRepo=personaRepo; this.productoRepo=productoRepo; this.ubicacionRepo=ubicacionRepo;
    }
    @PostMapping public ResponseEntity<?> crearVenta(@RequestBody VentaRequest req){
        Persona p = personaRepo.findById(req.getPersonaId()).orElse(null);
        Producto pr = productoRepo.findById(req.getProductoId()).orElse(null);
        if(p==null||pr==null) return ResponseEntity.badRequest().body("Persona o Producto no existe");
        Ubicacion u = null;
        if(req.getUbicacionId()!=null) u = ubicacionRepo.findById(req.getUbicacionId()).orElse(null);
        Venta v = new Venta(); v.setPersona(p); v.setProducto(pr); v.setUbicacion(u);
        int cantidad = req.getCantidad()==null?1:req.getCantidad();
        v.setCantidad(cantidad); v.setTotal(pr.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
        Venta saved = ventaRepo.save(v);
        return ResponseEntity.status(201).body(saved);
    }
    @GetMapping("/por-persona/{personaId}") public List<Venta> ventasPorPersona(@PathVariable Long personaId){ return ventaRepo.findByPersonaId(personaId); }
    @GetMapping("/por-producto") public List<ProductoVentasDTO> cantidadPorProducto(){ return ventaRepo.cantidadVendidaPorProducto(); }
}
