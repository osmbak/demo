package com.example.demo.service;


import com.example.demo.common.enums.OrderEnums;
import com.example.demo.common.models.ItemsBean;
import com.example.demo.common.models.OrderBean;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderRepository;
import jakarta.annotation.Resource;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.beans.EventHandler;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;
    @Autowired
    private Mapper mapper;
    //@Autowired
    //private EventHandler eventHandler;

    public String createOrder(OrderBean orderBean) {

        OrderEntity orderEntity = createRequiredOrderDTOFromBean(orderBean);
        orderEntity = orderRepository.save(orderEntity);
        //eventHandler.publishEvent(orderEntity);
        return  "Order created successfully !!!";
    }

    private OrderEntity createRequiredOrderDTOFromBean(OrderBean orderBean) {
        OrderEntity orderEntity = mapper.map(orderBean, OrderEntity.class);
        orderEntity.getItemEntities().clear();
        Set<ItemsBean> itemBeanSet = orderBean.getItems();
        for (ItemsBean itemsBean : itemBeanSet) {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setItemName(itemsBean.getItemName());
            itemEntity.setOrderEntity(orderEntity);
            orderEntity.getItemEntities().add(itemEntity);
        }
        orderEntity.setStatus(OrderEnums.PENDING);
        return orderEntity;
    }

    public void updateOrderStatus(Long orderId, OrderEnums orderStatus) {
        Optional<OrderEntity> order = orderRepository.findById(orderId);
        order.ifPresent(value -> value.setStatus(orderStatus));
        order.ifPresent(value -> orderRepository.save(value));

    }

}
