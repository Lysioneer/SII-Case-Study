package com.sii.rest;

import com.sii.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link TransactionController}
 *
 * Created by Simek Jan on  21.9.2023.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @MockBean
    private TransactionService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void saveRecord() throws Exception {

        Mockito.doNothing().when(service).saveRecord(Mockito.any());

        MvcResult mvcResult = mvc.perform(post("/secured/v1/record").content("{\n" +
                "    \"timeStamp\":\"2015-11-20\",\n" +
                "    \"type\":\"type\",\n" +
                "    \"actor\":\"actor\",\n" +
                "    \"transactionData\":{\n" +
                "        \"CS\": \"Post1\",\n" +
                "        \"Linux\": \"Post1\",\n" +
                "        \"Kotlin\": \"Post1\"\n" +
                "    }\n" +
                "}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        Assert.assertEquals("New record saved.", mvcResult.getResponse().getContentAsString());
    }

}
