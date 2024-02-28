package uo.mp.lab11.marker.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.lab11.marker.simulator.exception.InvalidExamException;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.log.Logger;


public class ExamParser {
	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<StudentExam> parse(List<String> lines) {
		ArgumentChecks.isTrue(lines != null, "Illegal null list");
		List<StudentExam> res = new LinkedList<>();
		for(String line: lines) {
			try {
				StudentExam exam = parseLine( line ); 
				checkInside(exam, res);
				res.add(exam);
			}catch(InvalidExamException e) {
				Logger.log(e.getMessage());
			}
		}
		return res;
	}

	private StudentExam parseLine(String line) {
		ArgumentChecks.isTrue(line!=null && (!line.isBlank() || !line.isEmpty()), "linea invalida");
		String parts[] = line.split("\t");
		String studentCode = parts[0];
		List<String> res = new ArrayList<>();
		
		for(int i = 1; i < parts.length; i++) {
			res.add( parts[i] );
		}
		StudentExam se = new StudentExam( studentCode, res );

		return se;
	}
	
	private void checkInside(StudentExam exam, List<StudentExam> exams) throws InvalidExamException {
		if(exams.contains(exam)) {
			throw new InvalidExamException("Entrega repetida del alumno con identificador: "+exam.getId());
		}
	}

}
