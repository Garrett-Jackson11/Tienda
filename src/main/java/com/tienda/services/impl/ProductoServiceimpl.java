/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.services.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jacgo
 */
@Service
public class ProductoServiceimpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        if (activo) {
            productos.removeIf(e -> !e.getActivo());
        }
        return productos;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //Lista de productos utilizando un metodo Query
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaQuery(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}
