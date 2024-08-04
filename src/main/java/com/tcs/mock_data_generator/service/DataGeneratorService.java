package com.tcs.mock_data_generator.service;

import com.tcs.mock_data_generator.model.Column;
import java.util.List;

public interface DataGeneratorService {
    List<List<String>> generateData(int noOfData, List<Column> columnList);
}
