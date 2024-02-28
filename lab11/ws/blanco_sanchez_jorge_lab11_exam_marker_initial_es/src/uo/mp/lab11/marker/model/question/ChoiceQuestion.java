package uo.mp.lab11.marker.model.question;

import uo.mp.util.check.ArgumentChecks;

public class ChoiceQuestion extends Question {

	private String rightAnswer;

	/**
	 * 
	 * @param weight
	 * @param rightAnswer
	 * @throws IllegalArgumentException if
	 * 			* weight <= 0
	 * 			* rightAnswer is null or blank
	 */
	public ChoiceQuestion(int number, double weight, String rightAnswer) {
		super( number, weight );
		checkName(rightAnswer);
		this.rightAnswer = rightAnswer;
	}

	/**
	 * 
	 * @param answer
	 * @return
	 * @throws IllegalArgumentException if answer is null or blank
	 */
	@Override
	public double mark(String answer) {
		checkName(answer);
		return getRightAnswer().equals( answer ) 
				? getWeight() 
				: getWeight() * -0.2;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}
	
	private void checkName(String name) {
		ArgumentChecks.isTrue(name!=null && (!name.isBlank() || !name.isEmpty()), "nombre invalido");
	}
	
	public boolean equals(Object e) {
		if(e==null) {
			return false;
		}else if(this==e) {
			return true;
		}else if(!(e instanceof ChoiceQuestion)) {
			return false;
		}else {
			ChoiceQuestion question = (ChoiceQuestion) e;
			if(this.getNumber()== question.getNumber() &&
					this.getWeight()==question.getWeight() && this.getRightAnswer().equals(question.getRightAnswer())) {
				return true;
			}
		}
		return false;
	}

}
