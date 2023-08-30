package task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class datediff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a date and time in DD-MM-YYYY hh:mm format: ");
        String input = scanner.nextLine();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date enteredDate;
        
        try {
            enteredDate = dateFormat.parse(input);
            calculateDifference(enteredDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
        
        scanner.close();
    }
    
    public static void calculateDifference(Date enteredDate) {
        Date currentDate = new Date();
        long differenceInMillis = enteredDate.getTime() - currentDate.getTime();
        
        if (differenceInMillis < 0) {
            System.out.println("Invalid date.");
            return;
        }
        
        long years = TimeUnit.MILLISECONDS.toDays(differenceInMillis) / 365;
        long months = TimeUnit.MILLISECONDS.toDays(differenceInMillis) / 30;
        long weeks = TimeUnit.MILLISECONDS.toDays(differenceInMillis) / 7;
        long days = TimeUnit.MILLISECONDS.toDays(differenceInMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis);
        
        if (years > 0) {
            System.out.println("Difference in years: " + years);
        } else if (months > 0) {
            System.out.println("Difference in months: " + months);
        } else if (weeks > 0) {
            System.out.println("Difference in weeks: " + weeks);
        } else if (days > 0) {
            System.out.println("Difference in days: " + days);
        } else {
            System.out.println("Difference in minutes: " + minutes);
        }
    }
}