package br.vbpfelipe.udemy.javacursocompleto.interfaces.model.entities;

public class Invoice {
	
	private Double basicPayment;
	
	private Double tax;
	
	private Invoice() {
		
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double gettotalPayment() {
		return this.getBasicPayment() - this.getTax();
	}
	
}
