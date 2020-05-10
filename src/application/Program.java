package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.nextLine());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.nextLine());
	
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.nextLine());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.nextLine());
			
			reservation.updateDates(checkin, checkout);
			System.out.print("reservation: " + reservation);
			sc.close();
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}
}