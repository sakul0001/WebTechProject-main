package edu.tcu.cs.superfrogproject.dao;

import edu.tcu.cs.superfrogproject.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
