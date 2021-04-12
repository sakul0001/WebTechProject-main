package edu.tcu.cs.superfrogproject.service;

import edu.tcu.cs.superfrogproject.dao.ProductRepository;
import edu.tcu.cs.superfrogproject.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        return productRepository.findById(id).get();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }
}
