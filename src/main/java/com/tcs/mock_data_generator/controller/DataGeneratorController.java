package com.tcs.mock_data_generator.controller;

import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                    "Type of data can be generated\n" +
                    "     1) firstName\n" +
                    "     2) lastName\n" +
                    "     3) city\n" +
                    "     4) Integer in particular range\n" +
                    "     eg. 1111 to 9999\n" +
                    "     \t    age(0, 150), empId(111111, 999999), pinCode(400000, 900000), so on...\n" +
                    "     5)Time in particular range"
    )
    @PostMapping("/generate")
    public List<List<String>> generator(
            @RequestParam int noOfData,
            @RequestBody List<Column> columnList
    ) {
        return dataGeneratorService.generateData(noOfData, columnList);
    }
}
