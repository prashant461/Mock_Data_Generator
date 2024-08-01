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
    private DataPattern dataPattern;


    /*
    add other field such as range for integer,
     */
}
