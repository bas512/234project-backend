package camt.se234.project.dao;

import camt.se234.project.entity.SaleOrder;
import camt.se234.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class OrderDaoImpl implements OrderDao {

    List<SaleOrder> saleOrders;
    public OrderDaoImpl(){
        saleOrders = new ArrayList<>();
        saleOrders.add(new SaleOrder("111","001"));
        saleOrders.add(new SaleOrder("112","002"));
        saleOrders.add(new SaleOrder("113","003"));
    }

    @Override
    public List<SaleOrder> findAll(){
        return  this.saleOrders;
    }

    OrderRepository orderRepository;
    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public SaleOrder addOrder(SaleOrder saleOrder) {
        return orderRepository.save(saleOrder);
    }

    @Override
    public List<SaleOrder> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

}
