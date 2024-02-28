package uo.mp.lab11.marker.service.sort;

import java.util.Comparator;

import uo.mp.lab11.marker.model.StudentMark;

public class ResultSorter implements Comparator<StudentMark>{

	public int compare(StudentMark o1, StudentMark o2) {
		return  (int)( o1.getMark()*100-o2.getMark()*100);
	}
}
