
package com.profecarlos.tallerapirest.restapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profecarlos.tallerapirest.restapi.model.Product;
import com.profecarlos.tallerapirest.restapi.repository.ProductRepository;
@RestController
@RequestMapping("/api/v1")
public class ProductController {
// Inyección del repositorio
@Autowired
private ProductRepository productRepository;
@PostMapping("product")
public ResponseEntity<Product> insertProduct(@RequestBody Product producto) {
// Ya no necesitamos generar IDs manualmente, JPA lo hará por nosotros
// También elimina la referencia a productList que ya no necesitamos
Product savedProduct = productRepository.save(producto);
return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
}
@GetMapping("products")
public ResponseEntity<List<Product>> getAllProducts() {
List<Product> products = productRepository.findAll();
return new ResponseEntity<>(products, HttpStatus.OK);
}
// Métodos adicionales para completar el CRUD
@GetMapping("product/{id}")
public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
return productRepository.findById(id)
.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
// Método para buscar por categoría (usando el método personalizado del repositorio
@GetMapping("products/categoria/{categoria}")
public ResponseEntity<List<Product>> getProductsByCategoria(@PathVariable String
categoria) {
List<Product> products = productRepository.findByCategoria(categoria);
return new ResponseEntity<>(products, HttpStatus.OK);
}
}