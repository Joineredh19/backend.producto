package com.hypersoft.productos.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hypersoft.productos.entities.Producto;
import com.hypersoft.productos.services.ProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        try {
            Producto guardaProducto = productoService.guardarProducto(producto);
            return new ResponseEntity<>(guardaProducto, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Producto> updateBook(@RequestBody Producto producto){
        try {
            Producto actualizarProducto= productoService.actualizarProducto(producto);
            return new ResponseEntity<>(actualizarProducto, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto(){
        return new ResponseEntity<>(productoService.getAllProductos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getBookById(@PathVariable Long id) {
        Optional<Producto> book = productoService.getProductoByid(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws IOException {
        Optional<Producto> producto = productoService.getProductoByid(id);
        if (producto.isPresent()){
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
