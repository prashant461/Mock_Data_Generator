package com.tcs.mock_data_generator.service.impl;

import com.tcs.mock_data_generator.mock_data.Data;
import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGeneratorServiceImpl implements DataGeneratorService {
    Random random = new Random();

    @Override
    public List<List<String>> generateData(int noOfData, List<Column> columnList) {
        List<List<String>> data = new ArrayList<>();

        Data dataGenerator = new Data(); // Assumes Data class is properly implemented
        Random random = new Random();

        for (int i = 0; i < noOfData; i++) {
            List<String> rowData = new ArrayList<>();

            for (Column column : columnList) {
                String str = "";
                switch (column.getDomainType()) {
                    case "FirstName":
                        str = dataGenerator.getFirstNames();
                        break;
                    case "LastName":
                        str = dataGenerator.getLastNames();
                        break;
                    case "City":
                        str = dataGenerator.getCities();
                        break;
                    case "Integer":
                        str += generateIntegerFromRange(column.getDataPattern().getStartRange(), column.getDataPattern().getEndRange());
                        break;
                    case "Time":
                        str += getRandomTimeFromRange(column.getDataPattern().getStartTime(), column.getDataPattern().getEndTime());
                        break;
                    default:
                        throw new RuntimeException("No such Domain type exists: " + column.getDomainType());
                }
                rowData.add(str);
            }
            data.add(rowData);
        }

        return data;
    }

    // not for unique number
    private int generateIntegerFromRange(int start, int end) {
        // Generate a random integer between start (inclusive) and end (inclusive)
        return random.nextInt(start, end+1);
    }

    private LocalTime getRandomTimeFromRange(String start, String end) {
        int[] st = convertTimeToInteger(start);
        int[] et = convertTimeToInteger(end);
        // Define the start and end times
        LocalTime startTime = LocalTime.of(st[0], st[1], st[2]);  // 9:00:00 AM
        LocalTime endTime = LocalTime.of(et[0], et[1], st[2]);  // 6:00:00 PM

        // Convert the times to seconds from start of the day
        int startSeconds = startTime.getHour() * 60 * 60 + startTime.getMinute() * 60 + startTime.getSecond();
        int endSeconds = endTime.getHour() * 60 * 60 + endTime.getMinute() * 60 + startTime.getSecond();

        // Generate a random number of seconds between the start and end
        int randomSeconds = random.nextInt(startSeconds, endSeconds);

        // Convert the random seconds back to LocalTime
        int hours = randomSeconds / (60 * 60);
        int remaining = randomSeconds % (60 * 60);
        int minutes =  remaining / 60;
        int seconds = remaining % 60;

        return LocalTime.of(hours, minutes, seconds);
    }

    private int[] convertTimeToInteger(String time) {
        int hours = (time.charAt(0)-'0')*10 + time.charAt(1)-'0';
        int minutes = (time.charAt(3)-'0')*10 + time.charAt(4)-'0';
        int seconds = (time.charAt(6)-'0')*10 + time.charAt(7)-'0';
        return new int[]{hours, minutes, seconds};
    }
}
