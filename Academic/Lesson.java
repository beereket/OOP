package Academic;

import java.time.LocalDate;
import java.util.*;

import Academic.Enums.*;
import Users.*;

public class Lesson {
	private LessonType type; // lab, practice, lesson
	private LocalDate time; // 14:00
	private int weekDay; // 0: monday 1: tuesday ....
	private Teacher instructor;
	private int room;
	private int duration;  // in hours
	private boolean isOffline;
	private HashMap<Student, Integer> students; // Student: Attendance(Enum);
	
	public Lesson() {
		students = new HashMap<Student, Integer>();
	}
	public Lesson(LessonType type, LocalDate time, int weekDay, Teacher instructor, int room, int duration, boolean isOffline, HashMap<Student, Integer> students) {
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
	public HashMap<Student, Integer> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Student, Integer> students) {
		this.students = students;
	}
	public Teacher getInstructor() {
		return instructor;
	}
	public void setInstructor(Teacher instructor) {
		this.instructor = instructor;
	}
	
	
}