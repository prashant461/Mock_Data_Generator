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
                    "[Domain Type: DEFAULT, INCREASING, DECREASING, INCREASE_BY_OFFSET]"
    )
    @PostMapping("/generate")
    public List<List<String>> generator(
            @RequestParam int noOfData,
            @RequestBody List<Column> columnList
    ) {
        return dataGeneratorService.generateData(noOfData, columnList);
    }
}
