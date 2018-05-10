package camt.se234.project.service;

import camt.se234.project.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAvailableProducts();
    int getUnavailableProductSize();

}
