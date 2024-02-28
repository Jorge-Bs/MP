package uo.mp.lab11.marker.parser.questionparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab11.marker.model.question.ChoiceQuestion;
import uo.mp.lab11.marker.model.question.GapQuestion;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.question.ValueQuestion;
import uo.mp.lab11.marker.parser.QuestionParser;



public class ParseTest {

	private QuestionParser qp;
	private List<String> string;
	private List<Question> result;
	
	@BeforeEach
	public void setUp() {
		qp = new QuestionParser();
		string = new ArrayList<>();
	}
	
	/**
	 * Given: una lista con una cadena correcta
	 * when: se invoca al metodo
	 * Then: devuelve una lista con el resultado
	 */
	@Test
	public void correctString() {
		string.add("choice	1.0	a");
		string.add("gap	0.5	stuff");
		string.add("value	1.5	12.5");
		
		result= qp.parse(string);
		assertEquals(3,result.size());
		
		Question q = new ChoiceQuestion(1, 1.0, "a");
		Question q1 = new GapQuestion(2, 0.5, "stuff");
		Question q2 = new ValueQuestion(3, 1.5, 12.5);
		
		assertTrue(result.contains(q));
		assertTrue(result.contains(q1));
		assertTrue(result.contains(q2));
	}
	
	/**
	 * Given: una lista con una cadena incorrecta
	 * When: se invoca al metodo
	 * Then: no se procesa la linea
	 */
	@Test
	public void invalidExam() {
		string.add("unknown	1.0	a");
		result = qp.parse(string);
		assertEquals(0,result.size());
	}
	
	
	

}
