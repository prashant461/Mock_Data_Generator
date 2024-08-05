package com.tcs.mock_data_generator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Column {
    private String columnName;
    private String domainType;
    private String stringValue;
    private String prefix;
    private String suffix;
    private int decimalForDouble;

    private String[] valuesForBoolean;
    private DataPattern dataPattern;
}
