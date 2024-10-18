package com.hypersoft.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hypersoft.productos.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {//Ya nos trae metodos como get all get by id y otros
    
}
