package edu.miu.demo.controller;

import edu.miu.demo.model.Product;
import edu.miu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> findAll() {return productService.findAll();}

    @PostMapping()
    public void create(@RequestBody Product product) {
        productService.create(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable int id){
        product.setId(id);
        productService.create(product);
        return ResponseEntity.ok("ProductV1 updated!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {productService.delete(id);}

//    @GetMapping("/{minPrice}")
    @GetMapping("/filter/minprice")
    public ResponseEntity<List<Product>> findAllByPriceGreaterThan(@RequestParam("minPrice") Double minPrice) {
        List<Product> products = productService.findAllByPriceGreaterThan(minPrice);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter/name")
    public ResponseEntity<List<Product>> findAllByNameContains(@RequestParam("key") String key) {
        List<Product> products = productService.findAllByNameContains(key);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter/category-maxprice")
    public ResponseEntity<List<Product>> findByCategoryNameAndPriceLessThan(@RequestParam("maxPrice") Double maxPrice, @RequestParam("category") String category) {
        List<Product> products = productService.findByCategoryNameAndPriceLessThan(category, maxPrice);
        return ResponseEntity.ok(products);
    }

}
