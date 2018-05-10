package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;

import java.util.List;

public interface SaleOrderService {
    SaleOrder addSaleOrder(SaleOrder order);
    List<SaleOrder> getSaleOrders();
    double getAverageSaleOrderPrice();

}
