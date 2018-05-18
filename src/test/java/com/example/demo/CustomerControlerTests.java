package com.example.demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.estar.demo.controller.CustomerController;


@RunWith(SpringJUnit4ClassRunner.class)


@WebAppConfiguration

public class CustomerControlerTests {

    private MockMvc mvc;

    @Before

    public void setUp() throws Exception {

        mvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();

    }

    @Test

    public void getHello() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/custom/hello").accept(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andDo(MockMvcResultHandlers.print())

                .andReturn();

    }

}