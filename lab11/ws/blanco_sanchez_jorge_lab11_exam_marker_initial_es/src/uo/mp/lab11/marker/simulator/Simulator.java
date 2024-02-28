package uo.mp.lab11.marker.simulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.lab11.marker.model.StudentMark;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.service.ExamMarker;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.log.Logger;

public class Simulator {

	private static final String EXAM_MODEL_FILE = "questions.txt";
	private static final String ANSWERS_FILE = "answers.gz";
	private static final String RESULTS_FILE = "marks.txt";

	public void start() {
		try {
			simulateScenario();	
		}catch(FileNotFoundException e) {
			repairableException(e);
		}catch(Exception e) {
			irrepairableException(e);
		}
	}

	/**
	 * There is no user interface for this small program. This method
	 * simulates an example scenario of use.
	 * @throws IOException 
	 */
	private void simulateScenario() throws IOException {
		ExamMarker ex = new ExamMarker();
		ex.loadQuestions( EXAM_MODEL_FILE );
		showQuestions(ex.getQuestions());
		ex.loadAnswers( ANSWERS_FILE );
		showExams(ex.getAnswers());

		ex.mark();

		showMarks( ex.getMarksByMark(), " by ascending mark" );
		showMarks( ex.getMarksByStudent(), " by ascending student id" );
		ex.saveResults( RESULTS_FILE );
	}

	private void showQuestions(List<Question> questions) {
		checkList(questions);
		System.out.println("---------------------------------------------");
		System.out.println("List of questions");
		for(Question q: questions) {
			System.out.println( q.toString() );
		}
	}

	private void showExams(List<StudentExam> exams) {
		checkList(exams);
		System.out.println("---------------------------------------------");
		System.out.println("List of exams");
		for(StudentExam se: exams) {
			System.out.println( se.toString() );
		}
	}

	private void showMarks(List<StudentMark> marks, String string) {
		checkList(marks);
		ArgumentChecks.isTrue(string!=null && (!string.isBlank() || !string.isEmpty()), "nombre invalido");
		System.out.println("---------------------------------------------");
		System.out.println("List of marks" + string);
		for(StudentMark mark: marks) {
			System.out.println( mark.toString() );
		}
	}

	private void repairableException(FileNotFoundException e) {
		Logger.log("Error recuperable: "+ e.getMessage());
		System.out.println(e.getMessage()+" Vuelva a intentarlo");
		
	}
	
	private void irrepairableException(Exception e) {
		Logger.log("Error recuperable: "+ e.getMessage());
		System.err.println("Se ha detecatado un error en el programa, pongase en contacto con el servicio tecnico");
		
	}
	
	private <T> void checkList(List<T> list) {
		ArgumentChecks.isTrue(list!=null,"la lista no puede ser null");
	}

}
