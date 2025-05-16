
package com.profecarlos.tallerapirest.restapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profecarlos.tallerapirest.restapi.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
// Métodos personalizados (opcionales)
List<Product> findByCategoria(String categoria);
List<Product> findByPrecioLessThan(double precio);
}