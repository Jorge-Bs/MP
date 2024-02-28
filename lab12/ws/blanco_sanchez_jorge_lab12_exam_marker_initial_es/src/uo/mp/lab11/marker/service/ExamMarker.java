package uo.mp.lab11.marker.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.lab11.marker.model.StudentMark;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.parser.ExamParser;
import uo.mp.lab11.marker.parser.QuestionParser;
import uo.mp.lab11.marker.service.sort.ResultSorter;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;


public class ExamMarker {
	/*
	 * file questions.txt is read and parsed into questions list
	 */
	private List<Question> questions = new ArrayList<>();
	/*
	 * file answers.gz is read and parsed into answers list
	 */
	private List<StudentExam> answers = new ArrayList<>();
	/*
	 * Student marks are computed and stored into marks list
	 */
	private List<StudentMark> marks = new ArrayList<>();


	/**
	 * 
	 * @param examModelFile
	 * @throws IllegalArgumentException if examModelFile is null or blank
	 * @throws FileNotFoundException if examModelFile cannot be found
	 */
	public void loadQuestions(String questionsFilename) throws FileNotFoundException {
		checkName(questionsFilename);
		List<String> lines = readQuestionLines(questionsFilename);
		List<Question> questions = new QuestionParser().parse( lines );
		addQuestions( questions );
	}
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private List<String> readQuestionLines(String fileName) throws FileNotFoundException {
		checkName(fileName);
		try {
			List<String> procesado = new FileUtil().readLines(fileName);
			return procesado;
		}catch(FileNotFoundException e) {//quiero personalizar el mensage
			throw new FileNotFoundException("No se ha podido encontrar el archivo con nombre: "+ fileName);
		}
		
	}
	
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private void addQuestions(List<Question> quests) {
		checkList(quests);
		for(Question q:quests) {
			questions.add(q);
		}
		
	}

	/**
	 * 
	 * @param answersFilename
	 * @throws FileNotFoundException if answersFile cannot be found
	 * @throws IllegalArgumentException if answersFilename is null or blank
	 * @throws ExamMarkerException when there are more than one exam for the same student 
	 */
	public void loadAnswers(String answersFilename) throws FileNotFoundException {
		checkName(answersFilename);
		List<String> lines = readAnswerLines(answersFilename);
		List<StudentExam> exams = new ExamParser().parse( lines );
		addExams( exams );
	}

	/*
	 * FAKE IMPLEMENTATION 
	 */
	private List<String> readAnswerLines(String fileName) throws FileNotFoundException {
		checkName(fileName);
		try {
			List<String> res = new ZipFileUtil().readLines(fileName);
			return res;
		}catch(FileNotFoundException e) {
			throw new FileNotFoundException("No se ha podido encontrar el archivo con nombre: "+ fileName);
		}
	}

	/*
	 * TODO: FAKE IMPLEMENTATION
	 */
	private void addExams(List<StudentExam> exams) {
		checkList(exams);
		for(StudentExam exam:exams) {
			answers.add(exam);
		}
	}


	/**
	 * 
	 * @return the list of marks ordered by student id in ascending order
	 */
	public List<StudentMark> getMarksByStudent() {
		Collections.sort(marks);
		return marks;
	}

	/**
	 * 
	 * @return the list of marks ordered by grade in ascending order
	 * 			For the same grade, by ascending student id
	 */
	public List<StudentMark> getMarksByMark() {

		Collections.sort(marks, new ResultSorter());
		
		return this.marks;	
		
	}

	/**
	 * calculates the mark for each exam. 
	 * Generates StudentMark instances
	 */
	public void mark() {
		marks.clear();
		for(StudentExam exam:answers) {
			this.marks.add(new StudentMark(exam.getId(), exam.mark(questions)));
		}
	}
	
	

	/**
	 * 
	 * @param resultsFilename
	 * @throws IllegalArgumentException if resultsFilename is null or blank
	 */
	public void saveResults(String resultsFilename) {
		checkName(resultsFilename);
		List<String> save = new ArrayList<>();
		for(StudentMark mark:marks) {
			save.add(mark.serialize());
		}
		new FileUtil().writeLines(resultsFilename, save);
	}


	public List<StudentExam> getAnswers() {
		// TODO FAKE IMPLEMENTATION
		return answers ;
	}

	public List<Question> getQuestions() {
		// TODO FAKE IMPLEMENTATION
		return questions;
	}

	private void checkName(String name) {
		ArgumentChecks.isTrue(name!=null,"el nombre del archivo no puede ser null");
		ArgumentChecks.isTrue(!name.isBlank() || !name.isEmpty(), "EL nombre del fichero no puede ser vacio");
	}
	
	private <T> void checkList(List<T> list) {
		ArgumentChecks.isTrue(list!=null,"la lista no puede ser null");
	}

}
