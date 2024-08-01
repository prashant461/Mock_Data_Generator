package com.tcs.mock_data_generator.mock_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private List<String> firstNames;
    private List<String> lastNames;
    private List<String> cities;

    public Data() {
        firstNames = new ArrayList<>();
        lastNames = new ArrayList<>();
        cities = new ArrayList<>();

        populateFirstNames();
        populateLastNames();
        populateCities();
    }

    private void populateFirstNames() {
        String[] names = {
                "Aarav", "Aarushi", "Vivaan", "Anaya", "Aditya", "Diya", "Vihaan", "Ira", "Arjun", "Myra",
                "Sai", "Saanvi", "Ayaan", "Aadhya", "Krishna", "Anika", "Ishaan", "Tara", "Shaurya", "Navya",
                "Aarush", "Anjali", "Dhruv", "Meera", "Rishi", "Kiara", "Arnav", "Riya", "Aryan", "Kavya",
                "Arav", "Nitya", "Atharv", "Radhika", "Parth", "Tia", "Reyansh", "Simran", "Kavin", "Vidhi",
                "Raghav", "Aanya", "Nirav", "Shruti", "Krish", "Vaishnavi", "Kabir", "Mira", "Jivan", "Pooja",
                "Tejas", "Aaradhya", "Siddharth", "Prisha", "Devansh", "Aisha", "Kushal", "Tanya", "Nikhil", "Sahana",
                "Veer", "Charvi", "Harsh", "Sneha", "Aryan", "Jhanvi", "Harshith", "Ananya", "Sarthak", "Suhani",
                "Suryansh", "Avni", "Ayush", "Anushka", "Shanaya", "Aayush", "Ishita", "Sanya", "Shrey", "Aditi",
                "Kiaan", "Ritika", "Viraj", "Riya", "Dev", "Aarav", "Mihir", "Riya", "Advik", "Anvi",
                "Lakshya", "Aarya", "Shivansh", "Priya", "Advaith", "Saira", "Meghna", "Ankita", "Ishika", "Pihu"
        };
        firstNames.addAll(Arrays.asList(names));
    }

    private void populateLastNames() {
        String[] names = {
                "Patel", "Singh", "Sharma", "Gupta", "Verma", "Kumar", "Reddy", "Yadav", "Bhat", "Nair",
                "Das", "Mehta", "Rao", "Chowdhury", "Pillai", "Chatterjee", "Menon", "Naidu", "Khan", "Shetty",
                "Jain", "Rana", "Basu", "Nair", "Shukla", "Roy", "Kapoor", "Chandra", "Iyer", "Nambiar",
                "Pandey", "Mishra", "Joshi", "Reddy", "Bose", "Sen", "Desai", "Agarwal", "Mishra", "Ghosh",
                "Singh", "Rao", "Prasad", "Khan", "Dutta", "Nair", "Dasgupta", "Bhattacharya", "Gandhi", "Mishra",
                "Reddy", "Yadav", "Verma", "Shah", "Jain", "Pillai", "Chatterjee", "Nambiar", "Roy", "Kapoor",
                "Chandra", "Kumar", "Sharma", "Menon", "Pandey", "Bhat", "Khan", "Iyer", "Nair", "Pillai",
                "Chowdhury", "Chatterjee", "Naidu", "Sen", "Chandra", "Kapoor", "Singh", "Sharma", "Mishra", "Patel",
                "Reddy", "Gupta", "Bose", "Das", "Ghosh", "Verma", "Roy", "Chowdhury", "Rao", "Bhat",
                "Menon", "Chatterjee", "Sen", "Pillai", "Reddy", "Singh", "Sharma", "Kumar", "Iyer", "Patel"
        };
        lastNames.addAll(Arrays.asList(names));
    }

    private void populateCities() {
        String[] names = {
                "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Ahmedabad", "Chennai", "Kolkata", "Surat", "Pune", "Jaipur",
                "Lucknow", "Kanpur", "Nagpur", "Indore", "Thane", "Bhopal", "Visakhapatnam", "Pimpri-Chinchwad", "Patna", "Vadodara",
                "Ghaziabad", "Ludhiana", "Agra", "Nashik", "Faridabad", "Meerut", "Rajkot", "Kalyan-Dombivli", "Vasai-Virar", "Varanasi",
                "Srinagar", "Aurangabad", "Dhanbad", "Amritsar", "Navi Mumbai", "Allahabad", "Ranchi", "Howrah", "Coimbatore", "Jabalpur",
                "Gwalior", "Vijayawada", "Madurai", "Raipur", "Kota", "Guwahati", "Chandigarh", "Solapur", "Hubballi-Dharwad", "Mysore",
                "Tiruchirappalli", "Bareilly", "Aligarh", "Tiruppur", "Moradabad", "Jalandhar", "Bhubaneswar", "Salem", "Mira-Bhayandar", "Warangal",
                "Thiruvananthapuram", "Guntur", "Bhiwandi", "Saharanpur", "Gorakhpur", "Bikaner", "Amravati", "Noida", "Jamshedpur", "Bhilai",
                "Cuttack", "Firozabad", "Kochi", "Bhavnagar", "Dehradun", "Durgapur", "Asansol", "Nanded", "Kolhapur", "Ajmer",
                "Gulbarga", "Jamnagar", "Ujjain", "Loni", "Siliguri", "Jhansi", "Ulhasnagar", "Jammu", "Sangli", "Manguluru",
                "Erode", "Belgaum", "Kurnool", "Rajahmundry", "Tirunelveli", "Malegaon", "Gaya", "Udaipur", "Maheshtala", "Davanagere"
        };
        cities.addAll(Arrays.asList(names));
    }

    public String getFirstNames() {
        int index = (int) (Math.random()*100);
        return firstNames.get(index);
    }

    public String getLastNames() {
        int index = (int) (Math.random()*100);
        return lastNames.get(index);
    }

    public String getCities() {
        int index = (int) (Math.random()*100);
        return cities.get(index);
    }
}
