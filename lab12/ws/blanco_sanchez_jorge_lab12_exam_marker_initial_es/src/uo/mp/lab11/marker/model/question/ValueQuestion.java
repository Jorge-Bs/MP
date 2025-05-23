package uo.mp.lab11.marker.model.question;

import uo.mp.util.check.ArgumentChecks;

public class ValueQuestion extends Question {

	private Double rightAnswer;

	/**
	 * 
	 * @param weight
	 * @param rightAnswer
	 * @throws IllegalArgumentException if
	 * 			* weight <= 0 
	 */
	public ValueQuestion(int number, Double weight, Double rightAnswer) {
		super( number, weight );
		this.rightAnswer = rightAnswer;
	}

	/**
	 * 
	 * @param answer
	 * @return
	 * @throws IllegalArgumentException if answer is 
	 * 		- null or blank
	 * 		- invalid number format
	 */
	@Override
	public double mark(String answer) {
		ArgumentChecks.isTrue(answer!=null && (!answer.isBlank() || !answer.isEmpty()), "nombre invalido");
		double anwsValue = toDouble(answer);
		return isInRange(getRightAnswer(), anwsValue, 0.1) 
				? getWeight() 
				: 0.0;
	}

	private double toDouble(String answer) {
		try {
			return Double.parseDouble( answer );			
		} catch(NumberFormatException nfe) {
			throw new IllegalArgumentException(nfe);
		}
	}

	private boolean isInRange(double rightValue, double anwsValue,
			double delta) {
		return rightValue - delta <= anwsValue
				&& anwsValue <= rightValue + delta;
	}

	public double getRightAnswer() {
		return rightAnswer;
	}
	
	public boolean equals(Object e) {
		if(e==null) {
			return false;
		}else if(this==e) {
			return true;
		}else if(!(e instanceof ValueQuestion)) {
			return false;
		}else {
			ValueQuestion question = (ValueQuestion) e;
			if(this.getNumber()== question.getNumber() &&
					this.getWeight()==question.getWeight() && this.getRightAnswer()==question.getRightAnswer()) {
				return true;
			}
		}
		return false;
	}

}
