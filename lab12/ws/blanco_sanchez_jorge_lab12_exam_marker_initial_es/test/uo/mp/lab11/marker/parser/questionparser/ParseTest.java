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
	
	/*
	 * Casos
	 * Null -
	 * Lista Vacia -
	 * Lista con preguantas de cada tipo -
	 * lista con publicacion desconocida -
	 * lista con lineas en blanco -
	 * Lista con formato de numeros desconocidos/incorrectos-
	 * 						-peso
	 * 						-value
	 * Numero de campos incorrectos para cada tipo de choice
	 */
	
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
	 * Given: una lista con una publicacion desconocida
	 * When: se invoca al metodo
	 * Then: no se procesa la linea
	 */
	@Test
	public void invalidExam() {
		string.add("unknown	1.0	a");
		result = qp.parse(string);
		assertEquals(0,result.size());
	}
	
	/**
	 * Given: un null
	 * When: se invoca al metodo
	 * Then: salta un NullPointerException
	 */
	@Test
	public void nullParam() {
		try {
			result = qp.parse(null);
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: una lista Vacia
	 * Wwhen: se invoca al metodo
	 * Then: no se añade ningun elemento
	 */
	@Test
	public void nullList() {
		result= qp.parse(string);
		assertEquals(0, result.size());
	}
	
	
	/**
	 * GIven: una lista que contiene una linea en blanco
	 * When: se invoca al metodo
	 * Then: solo se añade la lista correcta
	 */
	@Test
	public void blankLine() {
		string.add(" ");
		string.add("choice	1.0	a");
		
		result= qp.parse(string);
		assertEquals(1, result.size());
		
		Question q = new ChoiceQuestion(2, 1.0, "a");
		assertTrue(result.contains(q));
	}
	
	/**
	 * Given: una lista con valores numericos incorrectos
	 * When: se invoca al metodo
	 * Then: toda la lista va a ser incorrecta, el resultado será vacio
	 */
	@Test
	public void invalidNumbers() {
		string.add("gap	0.5s	stuff");
		string.add("value	1.5	12.5t");
		string.add("value	1.o	12.5");
		string.add("choice	1.0k	a");
		
		result= qp.parse(string);
		assertEquals(0, result.size());
	}
	
	/**
	 * Given: una lista con cada tipo de respuesta y numero de campos invalidos
	 * When: se llama al metodo
	 * Then: la lista está totalmente incorrecta, el tamaño será 0
	 */
	@Test
	public void invalidQuestions() {
		string.add("gap	0.5	stuff	plane");
		string.add("value	1.5	");
		string.add("value");
		string.add("number	choice	1.0k	a");
		
		result= qp.parse(string);
		assertEquals(0, result.size());
	}
	
	

}
