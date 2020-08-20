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
import com.rosales.controller.ProductController;
import com.rosales.model.Product;
import com.rosales.service.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
	    ProductController.class
	})
public class ProductTest {
	
    private final String BASE_URL = "/product";

    private ObjectMapper objectMapper;

    @Autowired
    private ProductController controller;

    private MockMvc mockMvc;

    @MockBean
    private IProductService mockService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    
    @Test
    public void productCreate() throws Exception {

        Product prod = new Product();
        prod.setName("Teste");
        prod.setDescription("Description");
        prod.setPrecio(5.5);
        
        Product rpta = new Product();
        rpta.setIdProduct(1);
        rpta.setName(prod.getName());
        rpta.setDescription(prod.getDescription());
        rpta.setPrecio(prod.getPrecio());

       when(mockService.create(any(Product.class))).thenReturn(rpta);
        
        mockMvc.perform(post(BASE_URL)
                .content(objectMapper.writeValueAsString(prod))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(mockService, times(1)).create(any(Product.class));
    }

}
