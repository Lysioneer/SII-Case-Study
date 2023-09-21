package com.sii.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Response class for /secured/v1/record/{id}.
 *
 * Created by Simek Jan on 21.9.2023.
 */
@Getter
@Setter
public class RetrieveRecordResponse {

    private LocalDate timeStamp;
    private String type;
    private String actor;
    private HashMap<String, String> transactionData;
}
