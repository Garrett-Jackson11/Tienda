/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;

import com.tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author jacgo
 */
public interface ProductoService {

    public List<Producto> getProductos(boolean activo);

    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto esta vacÃ­o
    // Se actualiza un producto si el id del producto NO esta vacÃ­o
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parÃ¡metro
    public void delete(Producto producto);
    
     //Lista de productos utilizando un metodo Query
    public List<Producto> consultaQuery(double precioInf, double precioSup);
}
