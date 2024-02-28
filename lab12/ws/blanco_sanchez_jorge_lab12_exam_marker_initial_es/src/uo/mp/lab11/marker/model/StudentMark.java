package uo.mp.lab11.marker.model;



public class StudentMark implements Comparable<StudentMark>{
	private String id;
	private Double mark;
	
	/** 
	 * @param id
	 * @param mark If is < 0, attribute mark is set to zero.  
	 * @throws IllegalArgumentException if 
	 * 			- id is null or blank
	 */
	public StudentMark(String id, double mark) {
		this.id = id;
		this.mark = mark;
	}

	public double getMark() {
		return Math.round(mark*100.0)/100.0;
	}

	public String getStudentId() {
		return this.id;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: "+ getStudentId());
		sb.append(", Mark: "+getMark());
		return sb.toString();
	}
	
	public int compareTo(StudentMark mark) {
		return this.getStudentId().compareTo(mark.getStudentId());
	}
	
	public String serialize() {
		return "ID\t"+getStudentId()+"\tMark\t"+getMark();
	}
	
	public boolean equals(Object e) {
		if(this==e) {
			return true;
		}
		if(!( e instanceof StudentMark)) {
			return false;
		}else {
			StudentMark ex = (StudentMark) e;
			return this.getStudentId().equals(ex.getStudentId()) && this.getMark()==ex.getMark();
		}
		}
	}

	
