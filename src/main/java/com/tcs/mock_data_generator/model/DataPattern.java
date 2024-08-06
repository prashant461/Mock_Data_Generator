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
    private int intOffset;

    private double startDouble;
    private double endDouble;
    private double doubleOffset;

    private String startTime;
    private String endTime;
    private String timeOffset;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate dateOffset;

    private String startDateTime;
    private String endDateTime;
//    private String dateTimeOffset;
    private int offsetDays;
    private int offsetMonths;
    private int offsetYears;
}
