package com.b355.controller;

import com.b355.model.Credito;
import com.b355.repository.CreditoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreditoControllerTest {

    @Autowired
    private CreditoRepository repository;

    @Autowired
    private MockMvc mock;

    @Test
    public void getAllCreditsTest() throws Exception {
        URI uri = new URI("/creditos");
        String jsonRequest = "{\"item\": \"investimento-cdi\", \"valor\":\"100\"}";

        for(int i=0; i <= 2; i++){
            mock.perform(MockMvcRequestBuilders
                    .post(uri)
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON));
        }

        List<Credito> creditos = repository.findAll();
        Assert.assertNotNull(creditos.get(1));
    }

    @Test
    public void getOneTest(){
        Long id = 1L;
        Optional<Credito> credito = repository.findById(id);
        Assert.assertNotNull(credito);
    }

    @Test
       public void registerNewCreditTest() throws Exception {
        URI uri = new URI("/creditos");
        String jsonRequest = "{\"item\": \"investimento-cdi\", \"valor\":\"100\"}";

        mock.perform(MockMvcRequestBuilders
                .post(uri)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }
}
