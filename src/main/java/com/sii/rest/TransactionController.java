package com.sii.rest;

import com.sii.model.request.SaveRecordRequest;
import com.sii.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Controller class for saving and getting data from the database.
 *
 * Created by Simek Jan on 20.9.2023.
 */
@RestController
@RequestMapping(path = "/secured/v1/record")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping()
    public ResponseEntity saveRecord(@NotNull @RequestBody SaveRecordRequest request) {

        service.saveRecord(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("New record saved.");
    }

    @GetMapping("/{id}")
    public ResponseEntity retrieveRecord(@NotNull @PathVariable(name = "id") String id) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.retrieveRecord(Integer.valueOf(id)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
