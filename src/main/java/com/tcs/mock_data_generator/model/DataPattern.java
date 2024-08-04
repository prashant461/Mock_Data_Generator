package com.tcs.mock_data_generator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPattern {
    private PatternEnum patternName;
    private int startRange;
    private int endRange;
    private String startTime;
    private String endTime;
}
