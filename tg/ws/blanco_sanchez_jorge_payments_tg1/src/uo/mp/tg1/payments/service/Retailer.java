package uo.mp.tg1.payments.service;

import java.util.ArrayList;
import java.util.List;

import uo.mp.tg1.payments.model.Payments;

public class Retailer {

	private List<Payments> payments=new ArrayList<Payments>();
	
	
	
	/**
	 * Añade pagos al sistema
	 * @param payment pago a añdir
	 */
	public void addPayments(Payments payment) {
		payments.add(payment);
	}
	
	/**
	 * Processa los pagos que hay registrados
	 */
	public void process() {
		for(Payments pay:payments) {
			pay.valid();
		}
	}
	
	/**
	 * Calcula el importe total de los pagos
	 * @return sales de tipo double
	 */
	public double getTotalSales() {
		double sales=0;
		for(Payments pay: payments) {
			if(pay.isValid()) {
				sales += pay.getAmount();
			}
		}
		return sales;
	}
	
}
