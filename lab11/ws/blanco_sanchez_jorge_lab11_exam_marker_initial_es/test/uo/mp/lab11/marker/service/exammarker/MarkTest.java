package uo.mp.lab11.marker.service.exammarker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab11.marker.model.StudentMark;
import uo.mp.lab11.marker.service.ExamMarker;

public class MarkTest {

	private ExamMarker  ex;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException {
		ex= new ExamMarker();
		ex.loadQuestions("questions.txt");
		ex.loadAnswers("answers.gz");
	}
	
	/**
	 * GIven: un archivo con varios examenes
	 * When: se realiza el metodo
	 * then: se comprueba que la suma sea correcta
	 */
	@Test
	public void checkSum() {
		ex.mark();
		List<StudentMark> m = ex.getMarksByStudent();
		StudentMark m1 = new StudentMark("20209", 5.2);
		StudentMark m2 = new StudentMark("20210", 3.9);
		StudentMark m3 = new StudentMark("20211", 2.0);
		StudentMark m4 = new StudentMark("20213", 3.0);
		StudentMark m5 = new StudentMark("20214", 1.5);
		StudentMark m6 = new StudentMark("20215", 2.4);
		assertEquals(6,m.size());
		assertTrue(m.contains(m1));
		assertTrue(m.contains(m2));
		assertTrue(m.contains(m3));
		assertTrue(m.contains(m4));
		assertTrue(m.contains(m5));
		assertTrue(m.contains(m6));
		
	}

}
