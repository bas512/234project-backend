package camt.se234.project.dao;

import camt.se234.project.entity.Product;
import camt.se234.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductDaoImpl implements ProductDao{
    List<Product>products;
    public ProductDaoImpl(){
        products = new ArrayList<>();
        products.add(new Product(111L,"11","Book","Book for student","image",100.00));
        products.add(new Product(112L,"12","Pen","For write","image",25.75));
        products.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
    }

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAll(){ return this.products; }



}
