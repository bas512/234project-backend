package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTests {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOrders(){
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
