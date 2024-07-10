package org.example;

import org.example.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(scanner.nextLine());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(scanner.nextLine());

        if(checkOut.before(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(scanner.nextLine());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(scanner.nextLine());

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.println("Reservation error: " + error);
            }else{
                System.out.println("Reservation " + reservation);
            }

        }
    }
}