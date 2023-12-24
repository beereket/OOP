package Academic;

import Academic.Enums.LessonType;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Lesson implements Serializable {
	private LessonType type; // lab, practice, lesson
	private LocalDate time; // 14:00
	private int weekDay; // 0: monday 1: tuesday ....
	private Teacher instructor;
	private int room;
	private int duration;  // in hours
	private boolean isOffline;
	private HashMap<Student, StudentPerformance> students; // Student: Attendance(Enum) / Mark / Comment
	
	public Lesson() {
		students = new HashMap<Student, StudentPerformance>();
	}
	public Lesson(LessonType type, LocalDate time, int weekDay, Teacher instructor, int room, int duration, boolean isOffline, HashMap<Student, StudentPerformance> students) {
		this();
		
		this.type = type;
		this.time = time;
		this.weekDay = weekDay;
		this.instructor = instructor;
		this.room = room;
		this.duration = duration;
		this.isOffline = isOffline;
		this.students = students;
	}
	
	// Getters-Setters
	public LessonType getType() {
		return type;
	}
	public void setType(LessonType type) {
		this.type = type;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		if(weekDay >= 0 && weekDay <= 6) {
			this.weekDay = weekDay;
		}
		else {
			System.out.println("\nDebug: input exceed range of weekDays\n");
		}
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isOffline() {
		return isOffline;
	}
	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}
	public HashMap<Student,StudentPerformance> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Student, StudentPerformance> students) {
		this.students = students;
	}
	public Teacher getInstructor() {
		return instructor;
	}
	public void setInstructor(Teacher instructor) {
		this.instructor = instructor;
	}


					/* 				Operations 				*/
	public StudentPerformance studentInfo(Student student){
		if(students.containsKey(student)){
			StudentPerformance curSP = students.get(student);

			return curSP;
		}

		return null;
	}


	public void putAttendance(Student student, int att){
		if(students.containsKey(student)){
			StudentPerformance curSP = students.get(student);
			curSP.setAttendace(att);
			students.put(student, curSP);
		}
		else{
			// Exception: No such student on lecture
		}
	}
	public void putMark(Student student, int mark){
		if(students.containsKey(student)){
			StudentPerformance curSP = students.get(student);
			curSP.setMark(mark);
			students.put(student, curSP);
		}
		else{
			// Exception: No such student on lecture
		}
	}

	public void putComment(Student student,String comment){
		if(students.containsKey(student)){
			StudentPerformance curSP = students.get(student);
			curSP.setComment(comment);
			students.put(student, curSP);
		}
		else{
			// Exception: No such student on lecture
		}
	}
}