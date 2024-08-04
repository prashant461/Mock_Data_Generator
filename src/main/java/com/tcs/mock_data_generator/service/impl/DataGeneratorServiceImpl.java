package com.tcs.mock_data_generator.service.impl;

import com.tcs.mock_data_generator.mock_data.Data;
import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.model.DataPattern;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGeneratorServiceImpl implements DataGeneratorService {
    Random random = new Random();

    Data data = new Data();

    @Override
    public List<List<String>> generateData(int noOfData, List<Column> columnList) {
        List<List<String>> generatedData = new ArrayList<>();
        Data dataGenerator = new Data();
        // initializing empty list to store data
        for (int i = 0; i <= noOfData; i++) {
            generatedData.add(new ArrayList<>());
        }

        for (Column column : columnList) {
            generatedData.get(0).add(column.getColumnName());
            switch (column.getDomainType()) {
                case "FirstName" -> getFirstNames(generatedData, noOfData);
                case "LastName" -> getLastNames(generatedData, noOfData);
                case "City" -> getCities(generatedData, noOfData);
                case "Integer" -> getIntegerData(generatedData, column.getDataPattern(), noOfData);
                case "Time" -> getTimeData(generatedData, column.getDataPattern(), noOfData);
                case "Date" -> getDateData(generatedData, column.getDataPattern(), noOfData);
                default -> throw new RuntimeException("No such Domain type exists: " + column.getDomainType());
            }
        }
        return generatedData;
    }

    private void getDateData(List<List<String>> generatedData, DataPattern dataPattern, int noOfData) {
        LocalDate startDate = dataPattern.getStartDate();
        LocalDate endDate = dataPattern.getEndDate();
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
        // Calculate the number of days between the start and end dates
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        switch (dataPattern.getPatternName()) {
            case INCREASING -> {
                for(int i=1;i<=noOfData;i++) {
                    // Generate a random number of days to add to the startDate
                    daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                    long randomDays = random.nextLong(daysBetween + 1); // +1 to include endDate
                    LocalDate date = startDate.plusDays(randomDays);
                    startDate = date;
                    generatedData.get(i).add(date + "");
                }
            }
            case DECREASING -> {
                for(int i=1;i<=noOfData;i++) {
                    daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                    long randomDays = random.nextLong(daysBetween + 1); // +1 to include endDate
                    LocalDate date = endDate.minusDays(randomDays);
                    endDate = date;
                    generatedData.get(i).add(date + "");
                }
            }
            case INCREASE_BY_OFFSET -> {
                for(int i=1;i<=noOfData;i++) {
                    LocalDate offset = dataPattern.getDateOffset();
                    LocalDate date = startDate.plusDays(offset.getDayOfMonth()).plusMonths(offset.getMonthValue()).plusYears(offset.getYear());
                    startDate = date;
                    generatedData.get(i).add(date + "");
                }
            }
            default -> {
                for(int i=1;i<=noOfData;i++) {
                    Long randomDays = random.nextLong(daysBetween + 1); // +1 to include endDate
                    LocalDate date = startDate.plusDays(randomDays);
                    generatedData.get(i).add(date + "");
                }
            }
        }
    }

    private void getTimeData(List<List<String>> generatedData, DataPattern dataPattern, int noOfData) {
        LocalTime startTime = convertTimeToLocalTime(dataPattern.getStartTime());
        LocalTime endTime = convertTimeToLocalTime(dataPattern.getEndTime());
//         Convert the times to seconds
        int startSeconds = startTime.getHour() * 60 * 60 + startTime.getMinute() * 60 + startTime.getSecond();
        int endSeconds = endTime.getHour() * 60 * 60 + endTime.getMinute() * 60 + startTime.getSecond();
        int newSeconds = 0;
        for(int i=1;i<=noOfData;i++) {
            switch (dataPattern.getPatternName()) {
                case INCREASING -> {
                    newSeconds = random.nextInt(startSeconds, endSeconds);
                    startSeconds = newSeconds;
                }
                case DECREASING -> {
                    newSeconds = random.nextInt(startSeconds, endSeconds);
                    endSeconds = newSeconds;
                }
                case INCREASE_BY_OFFSET -> {
                    LocalTime time = dataPattern.getTimeOffset();
                    int offset = time.getHour() * 60 * 60 + time.getMinute() * 60 + time.getSecond();
                    newSeconds = startSeconds + offset;
                    startSeconds = newSeconds;
                }
                default -> {
                    newSeconds = random.nextInt(startSeconds, endSeconds);
                }
            }
            // Convert the random seconds back to LocalTime
            int hours = newSeconds / (60 * 60);
            int remaining = newSeconds % (60 * 60);
            int minutes =  remaining / 60;
            int seconds = remaining % 60;
            generatedData.get(i).add(LocalTime.of(hours, minutes, seconds)+"");
        }
    }

    private LocalTime convertTimeToLocalTime(String time) {
        int hours = (time.charAt(0)-'0')*10 + time.charAt(1)-'0';
        int minutes = (time.charAt(3)-'0')*10 + time.charAt(4)-'0';
        int seconds = (time.charAt(6)-'0')*10 + time.charAt(7)-'0';
        return LocalTime.of(hours, minutes, seconds);
    }

    private void getIntegerData(List<List<String>> generatedData, DataPattern dataPattern, int noOfData) {
        switch (dataPattern.getPatternName()) {
            case INCREASING -> {
                int prev = dataPattern.getStartRange();
                int end = dataPattern.getEndRange();
                for(int i=1;i<=noOfData;i++) {
                    prev = random.nextInt(prev, end+1);
                    generatedData.get(i).add(prev+"");
                }
            }
            case DECREASING -> {
                int prev = dataPattern.getEndRange();
                int start = dataPattern.getStartRange();
                for(int i=1;i<=noOfData;i++) {
                    prev = random.nextInt(start, prev);
                    generatedData.get(i).add(prev+"");
                }
            }
            case INCREASE_BY_OFFSET -> {
                int start = dataPattern.getStartRange();
                int offset = dataPattern.getIntOffset();
                for(int i=1;i<=noOfData;i++) {
                    generatedData.get(i).add(start+"");
                    start += offset;
                }
            }
            default -> {
                for(int i=1;i<=noOfData;i++) {
                    generatedData.get(i).add(random.nextInt(dataPattern.getStartRange(), dataPattern.getEndRange())+"");
                }
            }
        }
    }

    private void getCities(List<List<String>> generatedData, int noOfData) {
        for (int i = 1; i <= noOfData; i++) {
            generatedData.get(i).add(data.getCity());
        }
    }

    private void getLastNames(List<List<String>> generatedData, int noOfData) {
        for (int i = 1; i <= noOfData; i++) {
            generatedData.get(i).add(data.getLastName());
        }
    }

    private void getFirstNames(List<List<String>> generatedData, int noOfData) {
        for (int i = 1; i <= noOfData; i++) {
            generatedData.get(i).add(data.getFirstName());
        }
    }

}
