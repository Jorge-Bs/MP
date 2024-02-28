package uo.mp.tg1.payments;

import uo.mp.tg1.payments.model.Cash;
import uo.mp.tg1.payments.model.CreditCard;
import uo.mp.tg1.payments.model.PayPal;
import uo.mp.tg1.payments.service.Retailer;

public class Main {
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		Retailer rt = new Retailer();
		rt.addPayments(new CreditCard("100", 100.0, "11111111111111111111", 12, 2018));
		rt.addPayments(new CreditCard("100", 100.0, "22222222222222222222", 12, 2023));
		rt.addPayments(new PayPal("101", 100.0, "john@gmail.com", "@34abX!"));
		rt.addPayments(new PayPal("102", 100.0, "mary@w3c.org", "xx_xxxx"));
		rt.addPayments(new Cash("102", 100.0));
		double sales=rt.getTotalSales();
		print(sales);
		rt.process();
		sales = rt.getTotalSales();
		print(sales);
		// crear un retailer
		
//		Crear crediCard con datos ("100", 100.0, "1111-1111-1111-1111", 12, 2018);  si es válido
//		Crear crediCard con datos ("100", 100.0, "22222222222222222222", 12, 2023); no es válido
//		Crear payPal con datos ("101", 100.0, "john@gmail.com", "@34abX!");   Si es válido 
//		Crear payPal con datos ("102", 100.0, "mary@w3c.org", "xx_xxxx" );     No es válido
//		Crear pago cash con datos ("102", 100.0);
		
//		Añadir pagos al retailer
//		Calcular venta total 
//		Imprimirla
//		
//		Procesar los pagos
//		
//		Calcular venta total
//		Imprimirla
		
		
	}
	
	private void print(double sales) {
		System.out.println("Total de ventas: "+sales);
	}

}
