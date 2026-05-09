package carrito.service;

import carrito.model.Producto;
import carrito.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private ProductoRepository productoRepository;

    public String procesarCompra(Long id, Integer cantidad) {
        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isPresent()) {
            double total = producto.get().getPrecio() * cantidad;
            return "Has añadido " + cantidad + " unidades de " + producto.get().getNombre() + 
                   ". Total a pagar: $" + total;
        } else {
            return "Error: El producto con ID " + id + " no existe.";
        }
    }
}

