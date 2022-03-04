package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}
		//capturando o tipo de exce��o Parse
		catch(ParseException e){
			System.out.println("Invalid date format!");
		}
		//capturando o tipo de exce��o personalizada Domain
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		//Catch com um tipo de exce��o gen�rico, para fazer o upcasting para RuntimeException e dar a mensagem gen�rica de erro:
		//Para o programa n�o quebrar, utilizar esse cacth para capturar qualquer outra exce��o inesperada:
		//InputMismatchException (quando o valor de entrada � errado) tamb�m � uma RuntimeException.
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();

	}

}
