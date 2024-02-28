package uo.mp.lab11.marker.service.exammarker;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.lab11.marker.service.ExamMarker;

public class LoadStudentExamsTest {
	
	private ExamMarker ex;
	private List<StudentExam> lex;
	
	
	@BeforeEach
	public void setUp() {
		ex= new ExamMarker();
		lex = new ArrayList<>();
	}

	/**
	 * Given: un archivo con un examen correcto
	 * When: se invoca al metodo
	 * Then: 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void correctFile() throws FileNotFoundException {
		ex.loadAnswers("fileContainsOneStudentExam.gz");
		lex = ex.getAnswers();
		assertEquals(1, lex.size());
	}
	
	/**
	 * Gieven: un archivo con varios examens y un examen repetido
	 * When: se invoca al metodo
	 * Then: devuelve una lista con todos los examens
	 * @throws FileNotFoundException 
	 */
	@Test
	public void repeatedExam() throws FileNotFoundException {
		ex.loadAnswers("fileContainsRepeatedStudentExams.gz");
		lex = ex.getAnswers();
		assertEquals(8, lex.size());
	}
	
	/**
	 * Gieven: un archivo desconocido
	 * when: se invoca al metodo
	 * Then: salta una fileNotFoundException
	 */
	@Test
	public void unknownFile() {
		try {
			ex.loadAnswers("exams.gz");
		}catch(FileNotFoundException e) {
			assertTrue(true);
		}
	}

}
