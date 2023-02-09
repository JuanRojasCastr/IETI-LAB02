package org.adaschool.api.service.product;

import org.adaschool.api.repository.product.Product;
import org.adaschool.api.repository.product.ProductDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceMap implements ProductsService {

    private final HashMap<String, Product> memory = new HashMap<>();

    @Override
    public Product save(Product product) {
        return memory.put(product.getId(), product);
    }

    @Override
    public Optional<Product> findById(String id) {
        Product product = memory.get(id);
        if (product == null) {
            return Optional.empty();
        }
        return Optional.of(product);
    }

    @Override
    public List<Product> all() {
        return null;
    }

    @Override
    public void deleteById(String id) {
        memory.remove(id);
    }

    @Override
    public Product update(ProductDto productDto, String id) {
            Product updatedProduct =  memory.get(id);
            updatedProduct.update(productDto);
            return updatedProduct;
    }

    @Override
    public String getMemory() {
        return this.memory.toString();
    }

}
