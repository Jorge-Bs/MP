package uo.mp.tg1.payments.model;

public class Cash extends Payments{

	
	/**
	 * Constructor que solicita el id y la cantida, se establece de forma predeterminda
	 * como invalida
	 * @param id de la transaccion 
	 * @param amount cantidad a pagar
	 */
	public Cash(String id,double amount) {
		setId(id);
		setAmount(amount);
		setValid(INVALID);
	}
	
	
	/**
	 * Valida el pago, cambia el valor del atributo
	 * 
	 */
	public void valid() {
		setValid(VALID);
	}
	
}
