package br.vbpfelipe.udemy.javacursocompleto.interfaces.application.model.service;

import java.time.Duration;

import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.CarRental;
import br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	
	private Double pricePerDay;
	
	private BrazilTaxService brazilTaxService;
	
	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService brazilTaxService) {
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.brazilTaxService = brazilTaxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public BrazilTaxService getBrazilTaxService() {
		return brazilTaxService;
	}

	public void setBrazilTaxService(BrazilTaxService brazilTaxService) {
		this.brazilTaxService = brazilTaxService;
	}
	
	public void processInvoice (CarRental carRental) {
		
		double hours = (Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes())/60.0;
		
		double basicPayment = 0.0;
		if( hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * Math.ceil(hours/24.0);
		}
		
		double tax = brazilTaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}
