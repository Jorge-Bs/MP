package uo.mp.lab11.marker.parser;

import java.util.ArrayList;

import java.util.List;

import uo.mp.lab11.marker.model.question.ChoiceQuestion;
import uo.mp.lab11.marker.model.question.GapQuestion;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.question.ValueQuestion;
import uo.mp.lab11.marker.simulator.exception.InvalidQuestionException;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.log.Logger;

public class QuestionParser {
	public static final int SIZE = 3;
	private int lineNumber;

	/**
	 * Recibe una lista de strings y las convierte al objeto de Tipo Question
	 * @param lines
	 * @return Question list
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<Question> parse(List<String> lines) {
//		List<Question> res = new LinkedList<>();
//		
//		res.add(new ChoiceQuestion(1, 1.0, "a"));
//		res.add(new ChoiceQuestion(2, 1.0, "b"));
//		res.add(new GapQuestion(3, 0.5, "stuff"));
//		res.add(new GapQuestion(4, 0.5, "computer"));
//		res.add(new ValueQuestion(5, 1.5, 12.5));
//		res.add(new ValueQuestion(6, 1.5, 100.0));
//		res.add(new GapQuestion(7, 1.0, "polymorphism"));
//		res.add(new ValueQuestion(8, 1.0, 256.0));
//		res.add(new ChoiceQuestion(9, 0.5, "c"));
//		res.add(new GapQuestion(10, 1.5, "abstract"));
		ArgumentChecks.isTrue(lines!=null,"El parámetro lines no puede ser null");
		this.lineNumber=0;
		List<Question> questions = new ArrayList<>();
		for(String line:lines) {
			try {
				lineNumber++;
				Question question = parseLine(line);
				questions.add(question);
			}catch(InvalidQuestionException e) {
				Logger.log(e.getMessage());
			}
		}
		return questions;
	}
	
	/**
	 * Transforma una linea un un objeto Question
	 * @param line
	 * @return question object
	 * @throws InvalidQuestionException
	 */
	private Question parseLine(String line) throws InvalidQuestionException {
		ArgumentChecks.isTrue(line!=null && (!line.isBlank() && !line.isEmpty()), "nombre invalido");
		String elements[]=line.split("\t");
		analizeLength(elements);
		switch(elements[0]) {
		case "choice":return parseChoice(elements);
		case "gap": return parseGap(elements);
		case "value": return parseValue(elements);
		default:
			throw new InvalidQuestionException("Tipo de pregunta invalida en línea "+ lineNumber);
		}
	}
	
	private void analizeLength(String[] elements) throws InvalidQuestionException {
		if(elements.length!=SIZE) {
			throw new InvalidQuestionException("Error en el número de campos en línea: "+lineNumber);
		}
	}
	
	/**
	 * Transforma la linea al objeto Question de tipo ChoiceQuestion
	 * @param elements
	 * @return ChoiceQuestion object
	 * @throws InvalidQuestionException
	 */
	private Question parseChoice(String elements[]) throws InvalidQuestionException {
		return new ChoiceQuestion(this.lineNumber, getDouble(elements[1]), elements[2]);
	}
	
	/**
	 * Transforma la linea al objeto Question de tipo GapQuestion
	 * @param elements
	 * @return GapQuestion object
	 * @throws InvalidQuestionException
	 */
	private Question parseGap(String elements[]) throws InvalidQuestionException {
		return new GapQuestion(this.lineNumber, getDouble(elements[1]), elements[2]);
	}
	
	/**
	 * Transforma la linea al objeto Question de tipo ValueQuestion
	 * @param elements
	 * @return ValueQuestion object
	 * @throws InvalidQuestionException
	 */
	private Question parseValue(String elements[]) throws InvalidQuestionException {
		return new ValueQuestion(this.lineNumber,getDouble(elements[1]), getDouble(elements[2]));
	}
	
	private double getDouble(String value) throws InvalidQuestionException {
		try {
			return Double.parseDouble(value);
		}catch(Exception e) {
			throw new InvalidQuestionException("Error en la linea "+ lineNumber+": argumento invalido"
					+"("+value+")");
		}
	}
	
	
	/**
	 * Comprueba si 
	 */
	
	

			
			
			

}
