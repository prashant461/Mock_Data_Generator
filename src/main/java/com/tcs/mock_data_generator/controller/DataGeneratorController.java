package com.tcs.mock_data_generator.controller;

import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@Tag(name = "Data Generator API", description = "API for generating data based on column configurations")
public class DataGeneratorController {

    @Autowired
    DataGeneratorService dataGeneratorService;

    @Operation(
            summary = "Generate data",
            description = "Generates data based on the provided column configurations.(add here more info)"
    )
    @PostMapping("/generate")
    public String generator(
            @RequestBody List<Column> columnList
    ) {
        return "Service called..";
    }
}
