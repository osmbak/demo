package com.example.demo.controller;

import com.example.demo.common.models.CustomerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerServiceController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    //@Autowired
    //private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody CustomerBean customer) {
        LOG.debug("==============Customer created============================");
        //return customerService.addCustomer(customer);
return "";
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public String deleteAllCustomers() {

        //return customerService.deleteAllCustomers();
        return "";
    }
}
