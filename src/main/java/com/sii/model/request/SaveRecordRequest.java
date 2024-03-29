package com.sii.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Request for /secured/v1/record.
 *
 * Created by Simek Jan on 20.9.2023.
 */
@Getter
@Setter
public class SaveRecordRequest {

    private LocalDate timeStamp;
    private String type;
    private String actor;
    private HashMap<String, String> transactionData;
}
