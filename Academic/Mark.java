package Academic;

import java.util.*;

import Academic.Enums.typeOfAttestation;
import Users.*;
import Academic.Enums.*;


public class Mark {
	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;
	
	private double total;
	private double gpa;
	private String literalMark;
	
	// Getters-Setters
	public double getFirstAttestation() {
		return firstAttestation;
	}
	public void setFirstAttestation(int firstAttestation) {
		this.firstAttestation = firstAttestation;
	}
	public double getSecondAttestation() {
		return secondAttestation;
	}
	public void setSecondAttestation(int secondAttestation) {
		this.secondAttestation = secondAttestation;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getLiteralMark() {
		return literalMark;
	}
	public void setLiteralMark(String literalMark) {
		this.literalMark = literalMark;
	}
	
	public void updateTotal() {
		total = firstAttestation + secondAttestation + finalExam;
	}
	public void transformMarks() {
        if (total >= 94.5) {
            literalMark = "A";
            gpa = 4.0;
        }
        else if (total >= 89.5) {
            literalMark = "A-";
            gpa = 3.67;
        }
        else if (total >= 84.5) {
            literalMark = "B+";
            gpa = 3.33;
        }
        else if (total >= 79.5) {
            literalMark = "B";
            gpa = 3.0;
        }
        else if (total >= 74.5) {
            literalMark = "B-";
            gpa = 2.67;
        }
        else if (total >= 69.5) {
            literalMark = "C+";
            gpa = 2.33;
        }
        else if (total >= 64.5) {
            literalMark = "C";
            gpa = 2.0;
        }
        else if (total >= 59.5) {
            literalMark = "C-";
            gpa = 1.67;
        }
        else if (total >= 54.5) {
            literalMark = "D+";
            gpa = 1.33;
        }
        else if (total >= 50) {
            literalMark = "D";
            gpa = 1.0;
        }
        else {
            literalMark = "F";
            gpa = 0;
        }
    }
	public void updateStatus() {
		updateTotal();
		transformMarks();
	}
	
	public void setMark(typeOfAttestation type, int mark) {
		switch(type) {
			case FIRST -> this.setFirstAttestation(mark);
			case SECOND -> this.setSecondAttestation(mark);
			case FINAL -> this.setFinalExam(mark);
		}
	}
	public void putMark(typeOfAttestation type, int mark) {
		switch(type) {
			case FIRST -> mark += this.getFirstAttestation();
			case SECOND -> mark += this.getSecondAttestation();
			case FINAL -> mark += this.getFinalExam();
		}
		this.setMark(type, mark);
	}
}
