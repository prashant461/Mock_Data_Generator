package com.tcs.mock_data_generator.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class DataPattern {
    private PatternEnum patternName;
    private int startRange;
    private int endRange;
    private String startTime;
    private String endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private int intOffset;
    private LocalTime timeOffset;
    private LocalDate dateOffset;
}
