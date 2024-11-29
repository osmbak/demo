package com.example.demo.service;

import com.example.demo.common.models.CustomerBean;
import com.example.demo.common.models.CustomerOrdersBean;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.CustomerOrdersEntity;
import com.example.demo.repository.CustomerOrderRepository;
import com.example.demo.repository.CustomerRepository;
import jakarta.annotation.Resource;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private Mapper mapper;
    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private CustomerOrderRepository customerOrderRepository;


    public String addCustomer(CustomerBean customerBean) {
        CustomerEntity customerEntity = mapper.map(customerBean, CustomerEntity.class);
        customerEntity = customerRepository.save(customerEntity);
        return "Cust" +
                "omer Created Successfully, Your CustomerId is "+customerEntity.getId();
    }

    public String createCustomerOrder(CustomerOrdersBean customerOrders) {
        LOG.debug("Going to create customer order");
        CustomerOrdersEntity customerOrder = mapper.map(customerOrders, CustomerOrdersEntity.class);
        customerOrderRepository.save(customerOrder);
        return "Order Created Successfully !!!";
    }

    public String deleteAllCustomers() {
        return "All customers deleted Successfully !!!";
    }

}
