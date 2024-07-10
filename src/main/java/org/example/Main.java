package org.example;

import org.example.model.entities.Reservation;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(scanner.nextLine());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(scanner.nextLine());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(scanner.nextLine());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(scanner.nextLine());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation " + reservation);
        }catch (ParseException e){
            System.out.println("Invalid date format");
        }catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Invalid input inserted");
        }catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }
}