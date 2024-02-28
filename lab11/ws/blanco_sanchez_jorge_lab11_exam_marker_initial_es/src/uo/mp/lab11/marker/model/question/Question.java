package uo.mp.lab11.marker.model.question;

import uo.mp.util.check.ArgumentChecks;

public abstract class Question {

	private int questionNumber;
	private Double weight;

	/**
	 * @param number
	 * @param weight
 	 * @throws IllegalArgumentException if question <= 0
	 * @throws IllegalArgumentException if weight <= 0
	 */
	public Question(int number, double weight) {
		ArgumentChecks.isTrue(number>0, "El numero de pregunta no puede ser 0 o negativo");
		ArgumentChecks.isTrue(weight>0.0, "El valor de la pregunta no puede ser 0 o negativo");

		this.questionNumber = number;
		this.weight = weight;
	}

	/**
	 * Devuelve la puntuacion obtenida en el ejercicio
	 * @param answer
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract double mark(String answer);

	/**
	 * Devuleve el peso del ejercicio, es decir, la calificacion maxima que se puede obtener
	 * @return nota maxima
	 */
	public double getWeight() {
		return weight;
	}
	
	public int getNumber() {
		return this.questionNumber;
	}

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", weight=" + weight + "]";
	}
	
	
	public abstract boolean equals(Object e);

	
}
