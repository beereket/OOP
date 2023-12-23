package Academic;

import Academic.Enums.SemesterType;
import Academic.Enums.typeOfAttestation;
import Users.Enums.Faculty;
import Users.Student;
import Users.Teacher;
import Util.Classes.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Course implements Serializable {
	private String code;
	private String title;
	private String description;
	private int credits;
	private String courseType; // ?
	private int semesterNum;
	private SemesterType semesterType;
	private Faculty faculty;
	
	private HashMap<Student, Mark> students;
	private HashSet<Teacher> instructors;
	private HashSet<Course> prerequisites;
	private HashSet<Lesson> lessons;
	
	public Course() {
		students = new HashMap<Student, Mark>();
		instructors = new HashSet<Teacher>();
		prerequisites = new HashSet<Course>();
		lessons = new HashSet<Lesson>();

	}
	public Course(String code, String title, String description, int credits, String courseType, int semesterNum,
			SemesterType semesterType, Faculty faculty) {
		this();
		this.code = code;
		this.title = title;
		this.description = description;
		this.credits = credits;
		this.courseType = courseType;
		this.semesterNum = semesterNum;
		this.semesterType = semesterType;
		this.faculty = faculty;

		Data.getInstance().getCourses().add(this);
	}
	
	// Getters-Setters
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getSemesterNum() {
		return semesterNum;
	}
	public void setSemesterNum(int semesterNum) {
		this.semesterNum = semesterNum;
	}
	public SemesterType getSemesterType() {
		return semesterType;
	}
	public void setSemesterType(SemesterType semesterType) {
		this.semesterType = semesterType;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public HashMap<Student, Mark> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Student, Mark> students) {
		this.students = students;
	}
	public HashSet<Teacher> getInstructors() {
		return instructors;
	}
	public void setInstructors(HashSet<Teacher> instructors) {
		this.instructors = instructors;
	}
	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(HashSet<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	
					/* 				Operatios				*/
	public void setMark(Student student, typeOfAttestation type, int mark) {
		Mark curMark = students.get(student);
		curMark.setMark(type, mark);
	}
	
	public void putMark(Student student, typeOfAttestation type, int mark) {
		Mark curMark = students.get(student);
		curMark.putMark(type, mark);
	}
}
