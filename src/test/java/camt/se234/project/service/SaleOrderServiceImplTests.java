package camt.se234.project.service;
import camt.se234.project.dao.OrderDao;
import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTests {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;


    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);

        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

//    ProductServiceImpl productService = new ProductServiceImpl();
//      productService.setProductDao(productDao);
//    List<Product> mockProduct = new ArrayList<>();
//      mockProduct.add(new Product(111L,"11","Book","Book for student","image",100.00));
//      mockProduct.add(new Product(112L,"12","Pen","For write","image",25.75));
//      mockProduct.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
//    when(productDao.findAll()).thenReturn(mockProduct);
//    assertThat(productService.getAllProducts());

        @Test
    public void testGetAverageSaleOrderPriceWithMock(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrders.add(new SaleOrder(111L,"001"));
        mockSaleOrders.add(new SaleOrder(112L,"002"));
        mockSaleOrders.add(new SaleOrder(113L,"003"));
        List<Product> mockProduct = new ArrayList<>();
        mockProduct.add(new Product(111L,"11","Book","Book for student","image",100.00));
        mockProduct.add(new Product(112L,"12","Pen","For write","image",25.75));
        mockProduct.add(new Product(113L,"13","Eraser","For removing writing from paper","image",19.00));
        when(productDao.findAll()).thenReturn(mockProduct);
        when(orderDao.findAll()).thenReturn(mockSaleOrders);
        //assertThat(saleOrderService.getAverageSaleOrderPrice(), is(closeTo(48.25,0.01)));
    }



    @Test
    public void testGetSaleOrdersWithMock(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrders.add(new SaleOrder(111L,"001"));
        mockSaleOrders.add(new SaleOrder(112L,"002"));
        mockSaleOrders.add(new SaleOrder(113L,"003"));
        when(orderDao.findAll()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getSaleOrders());
    }

}
