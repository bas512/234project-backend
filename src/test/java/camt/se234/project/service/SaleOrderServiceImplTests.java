package camt.se234.project.service;
import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.Matchers.hasItem;
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
    public void testGetAverageSaleOrderPriceWithMock(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrder.add(new SaleOrder("111","001"));
        mockSaleOrder.add(new SaleOrder("112","002"));
        mockSaleOrder.add(new SaleOrder("114","003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);
        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder("111","001"),
                new SaleOrder("112","002"), new SaleOrder("114","003")));
    }

    @Test
    public void testGetSaleOrdersWithMock(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrder.add(new SaleOrder("111","001"));
        mockSaleOrder.add(new SaleOrder("112", "002"));
        mockSaleOrder.add(new SaleOrder("113", "003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);
        assertThat(saleOrderService.getSaleOrders(),hasItem(new SaleOrder("111","001")));
    }

}
