package edu.miu.demo.repo;

import edu.miu.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(Double minPrice);
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);
    List<Product> findAllByNameContains(String key);
}
