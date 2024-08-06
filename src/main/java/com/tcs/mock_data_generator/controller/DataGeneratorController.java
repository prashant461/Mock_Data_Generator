package com.tcs.mock_data_generator.controller;

import com.opencsv.CSVWriter;
import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@Tag(name = "Data Generator API", description = "API for generating data based on column configurations")
public class DataGeneratorController {

    @Autowired
    DataGeneratorService dataGeneratorService;

    @Operation(
            summary = "Generate data",
            description = "Generates data based on the provided column configurations.\n" +
                    "Type of data can be generated:\n" +
                    "1) FirstName\n" +
                    "2) LastName\n" +
                    "3) City\n" +
                    "4) String\n" +
                    "5) SameString\n" +
                    "6) StringWithPrefixAndSuffix\n" +
                    "7) Boolean\n" +
                    "8) Integer\n" +
                    "9) Double\n" +
                    "10) Time\n" +
                    "11) Date\n" +
                    "12) Timestamp\n" +
                    "[Domain Type: DEFAULT, INCREASING, DECREASING, INCREASE_BY_OFFSET]"
    )
    @PostMapping("/generate")
    public ResponseEntity<InputStreamResource> generator(
            @RequestParam int noOfData,
            @RequestBody List<Column> columnList
    ) throws IOException{
//        return dataGeneratorService.generateData(noOfData, columnList);
        List<List<String>> data = dataGeneratorService.generateData(noOfData, columnList);

        // Create CSV content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream))) {
            for (List<String> row : data) {
                writer.writeNext(row.toArray(new String[0]));
            }
        }

        // Convert output stream to InputStreamResource
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        // Build response
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.csv");
        headers.add(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
    }
}
