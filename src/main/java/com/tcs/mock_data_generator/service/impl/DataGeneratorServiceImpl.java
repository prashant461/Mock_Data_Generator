package com.tcs.mock_data_generator.service.impl;

import com.tcs.mock_data_generator.model.Column;
import com.tcs.mock_data_generator.service.DataGeneratorService;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

/**
 * Type of data can be generated
 * 1) firstName
 * 2) lastName
 * 3) city
 * 4) Integer in particular range
 * 	eg. 1111 to 9999
 * 	    age(0, 150), empId(111111, 999999), pinCode(400000, 900000), so on...
 * 5)Time in particular range
 */
@Component
public class DataGeneratorServiceImpl implements DataGeneratorService {
    Random random = new Random();

    @Override
    public void genereateData(List<Column> columnList) {
        /**
         * get all details of colum configuration received from user and start creating data for it
         */
//        HashMap<Integer, List<Object>>
//        List<class(paritcular class but how to create one with variable number of fields)> so it can hold all types of data
        for(Column column : columnList) {

        }
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
        LocalTime startTime = LocalTime.of(st[0], st[1]);  // 9:00 AM
        LocalTime endTime = LocalTime.of(et[0], et[1]);  // 6:00 PM

        // Convert the times to minutes from start of the day
        int startMinutes = startTime.getHour() * 60 + startTime.getMinute();
        int endMinutes = endTime.getHour() * 60 + endTime.getMinute();

        // Generate a random number of minutes between the start and end
        int randomMinutes = random.nextInt(startMinutes, endMinutes);

        // Convert the random minutes back to LocalTime
        int hours = randomMinutes / 60;
        int minutes = randomMinutes % 60;

        return LocalTime.of(hours, minutes);
    }

    private int[] convertTimeToInteger(String time) {
        int hours = (time.charAt(0)-'0')*10 + time.charAt(1)-'0';
        int minutes = (time.charAt(3)-'0')*10 + time.charAt(4)-'0';
        return new int[]{hours, minutes};
    }
}
