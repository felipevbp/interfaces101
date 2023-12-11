package br.vbpfelipe.udemy.javacursocompleto.interfaces.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.CarRental;
import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental datas: ");
		System.out.println("Car model: ");
		String carModel = sc.nextLine();
		System.out.println("Started (dd/MM/yyyy): ");
		LocalDateTime startDateTime =LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Finishing (dd/MM/yyyy): ");
		LocalDateTime endDateTime =LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(startDateTime, endDateTime, new Vehicle(carModel));
		
		
		
		sc.close();
		
	}
}
