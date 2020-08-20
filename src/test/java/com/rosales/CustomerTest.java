package com.rosales;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosales.controller.CustomerController;
import com.rosales.model.Customer;
import com.rosales.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
	    CustomerController.class
	})
public class CustomerTest {
	
    private final String BASE_URL = "/customer";

    private ObjectMapper objectMapper;

    @Autowired
    private CustomerController controller;

    private MockMvc mockMvc;

    @MockBean
    private ICustomerService mockService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    
    @Test
    public void customerCreate() throws Exception {

        Customer cust = new Customer();
        cust.setFirstName("Alex");
        cust.setLastName("Silva");
        cust.setCpf("24232972899");
        cust.setEmail("al@gmail.com");
        cust.setTelephone("11984268598");
        cust.setAddress("sao paulo");       
       
        
        Customer rpta = new Customer();
        rpta.setIdCustomer(1);
        rpta.setFirstName(cust.getFirstName());
        rpta.setLastName(cust.getLastName());
        rpta.setCpf(cust.getCpf());
        rpta.setEmail(cust.getEmail());
        rpta.setTelephone(cust.getTelephone());
        rpta.setAddress(cust.getAddress()); 

       when(mockService.create(any(Customer.class))).thenReturn(rpta);
        
        mockMvc.perform(post(BASE_URL)
                .content(objectMapper.writeValueAsString(cust))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(mockService, times(1)).create(any(Customer.class));
    }

}
