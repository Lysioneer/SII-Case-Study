package com.sii.rest;

import com.sii.exception.RecordNotFoundException;
import com.sii.model.response.RetrieveRecordResponse;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    public void retrieveRecord() throws Exception {

        Mockito.when(service.retrieveRecord(3)).thenReturn(mockRetrieveRecordResponse());

        MvcResult mvcResult = mvc.perform(get("/secured/v1/record/3")).andExpect(status().isOk()).andReturn();

        Assert.assertEquals("{\"timeStamp\":\"2023-09-21\",\"type\":\"type\",\"actor\":\"actor\",\"transactionData\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void retrieveRecordNotFoundExceptionTest() throws Exception {

        Mockito.when(service.retrieveRecord(3)).thenThrow(new RecordNotFoundException("No suitable record found in db with id: 3"));

        MvcResult mvcResult = mvc.perform(get("/secured/v1/record/3")).andExpect(status().isNotFound()).andReturn();

        Assert.assertEquals("No suitable record found in db with id: 3", mvcResult.getResponse().getContentAsString());
    }

    private RetrieveRecordResponse mockRetrieveRecordResponse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        RetrieveRecordResponse response = new RetrieveRecordResponse();
        response.setTimeStamp(LocalDate.parse("2023-09-21", formatter));
        response.setType("type");
        response.setActor("actor");
        response.setTransactionData(new HashMap<String, String>());
        response.getTransactionData().put("key1", "value1");
        response.getTransactionData().put("key2", "value2");
        response.getTransactionData().put("key3", "value3");

        return response;
    }
}
