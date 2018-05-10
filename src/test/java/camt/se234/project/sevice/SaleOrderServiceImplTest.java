package camt.se234.project.sevice;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class SaleOrderServiceImplTest {

    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;
    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }




//    @Test
//    public void getSaleOrder(){
//        List<SaleOrder> mockSaleOrders = new ArrayList<>();
//
//        mockSaleOrders.add(orderDao.getOrders(),);
//
//
//    }
}
