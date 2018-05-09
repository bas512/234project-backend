package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTests {
   ProductDao productDao;
   ProductServiceImpl productService;

   @Before
    public void setup(){
       productDao = mock(ProductDao.class);
       productService = new ProductServiceImpl();
       productService.setProductDao(productDao);
   }

   @Test
   public void testGetAllProducts(){
      ProductServiceImpl productService = new ProductServiceImpl();
      productService.setProductDao(productDao);
      List<Product> mockProduct = new ArrayList<>();
      mockProduct.add(new Product(111L,"11","Book","Book for student","image",100.00));
      mockProduct.add(new Product(112L,"12","Pen","For write","image",25.75));
      mockProduct.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
      when(productDao.findAll()).thenReturn(mockProduct);
      assertThat(productService.getAllProducts());
   }

   @Test
   public void testGetAvailableProducts(){
      ProductServiceImpl productService = new ProductServiceImpl();
      productService.setProductDao(productDao);
      List<Product> mockProduct = new ArrayList<>();
      mockProduct.add(new Product(111L,"11","Book","Book for student","image",100.00));
      mockProduct.add(new Product(112L,"12","Pen","For write","image",25.75));
      mockProduct.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
      when(productDao.findAll()).thenReturn(mockProduct);
      assertThat(productService.getAvailableProducts());
   }

   @Test
   public void testGetUnavailableProductSize(){
      ProductServiceImpl productService = new ProductServiceImpl();
      productService.setProductDao(productDao);
      List<Product> mockProduct = new ArrayList<>();
      mockProduct.add(new Product(111L,"11","Book","Book for student","image",100.00));
      mockProduct.add(new Product(112L,"12","Pen","For write","image",25.75));
      mockProduct.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
      when(productDao.findAll()).thenReturn(mockProduct);
      assertThat(productService.getUnavailableProductSize());
   }
}