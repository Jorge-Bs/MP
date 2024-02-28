package uo.mp.tg1.payments.model;

import uo.mp.tg1.paypal.PayPalAPI;
import uo.mp.util.check.ArgumentChecks;

public class PayPal extends Payments{

	private String username;
	private String password;
	
	public PayPal(String id,double amount,String username,String password) {
		setId(id);
		setAmount(amount);
		setValid(INVALID);
		setUsername(username);
		setPassword(password);
	}
	
	
	/**
	 * Devuelve el username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * devuelve la constraseña
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * Establece el username
	 * @param username
	 */
	private void setUsername(String username) {
		ArgumentChecks.isTrue(!username.isBlank() && !username.isEmpty() && username!=null,"username invalido");
		this.username = username;
	}

	/**
	 * Establece la contraseña
	 * @param password
	 */
	private void setPassword(String password) {
		ArgumentChecks.isTrue(!password.isBlank() && !password.isEmpty() && password!=null,"password invalido");
		this.password = password;
	}


	/**
	 * Valida el pago
	 */
	@Override
	public void valid() {
		PayPalAPI api = new PayPalAPI();
		String token = api.logIn(getUsername(), getPassword());
		if(api.checkout(token, getId(), getAmount())) {
			setValid(VALID);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
