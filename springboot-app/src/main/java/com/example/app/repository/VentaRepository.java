package com.example.app.repository;
import com.example.app.model.Venta;
import com.example.app.dto.ProductoVentasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByPersonaId(Long personaId);
    @Query("SELECT new com.example.app.dto.ProductoVentasDTO(v.producto.id, v.producto.nombre, SUM(v.cantidad), SUM(v.total)) FROM Venta v GROUP BY v.producto.id, v.producto.nombre ORDER BY SUM(v.cantidad) DESC")
    List<ProductoVentasDTO> cantidadVendidaPorProducto();
}
