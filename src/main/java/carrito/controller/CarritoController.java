package carrito.controller;

import carrito.dto.CarritoDTO;
import carrito.service.CarritoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/agregar")
    public String agregarProducto(@RequestBody CarritoDTO datosEntrada) {
        return carritoService.procesarCompra(datosEntrada.getProductoId(), datosEntrada.getCantidad());
    }
}

