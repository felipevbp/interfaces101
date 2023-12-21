package br.vbpfelipe.udemy.javacursocompleto.interfaces.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.vbpfelipe.udemy.javacursocompleto.interfaces.application.model.service.BrazilTaxService;
import br.vbpfelipe.udemy.javacursocompleto.interfaces.application.model.service.RentalService;
import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.CarRental;
import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.print("Enter rental datas: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Started (dd/MM/yyyy): ");
		LocalDateTime startDateTime =LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Finishing (dd/MM/yyyy): ");
		LocalDateTime endDateTime =LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(startDateTime, endDateTime, new Vehicle(carModel));

		System.out.print("Enter with the price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter with the price per day: ");
		double pricePerday = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerday, new BrazilTaxService());
		rentalService.processInvoice(cr);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento Básico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Pagamento Total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		sc.close();
		
	}
}
