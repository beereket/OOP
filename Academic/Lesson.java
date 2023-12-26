package Academic;

import Academic.Enums.LessonType;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashMap;

public class Lesson implements Serializable {
	private LessonType type; // lab, practice, lesson
	private LocalTime time; // 14:00
	private int weekDay; // 0: monday 1: tuesday ....
	private Teacher instructor;
	private int room;
	private int duration;  // in hours
	private boolean isOffline;
	private HashMap<Student, StudentPerformance> students; // Student: Attendance(Enum) / Mark / Comment
	
	public Lesson() {
		students = new HashMap<>();
	}
	public Lesson(LessonType type, LocalTime time, int weekDay, Teacher instructor, int room, int duration, boolean isOffline, Collection<Student> students) {
		this();
		
		this.type = type;
		this.time = time;
		this.weekDay = weekDay;
		this.instructor = instructor;
		this.room = room;
		this.duration = duration;
		this.isOffline = isOffline;

		setStudents(students);
	}
	
	// Getters-Setters
	public LessonType getType() {
		return type;
	}
	public void setType(LessonType type) {
		this.type = type;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
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
	public void setStudents(Collection<Student> students) {
		for(Student student: students){
			this.students.put(student, new StudentPerformance());
		}
	}
	public Teacher getInstructor() {
		return instructor;
	}
	public void setInstructor(Teacher instructor) {
		this.instructor = instructor;
	}


					/* 				Operations 				*/
	/** Получить информацию с лекции о Студенте
	 * @param student указатель на студента
	 * @throws IllegalArgumentException если студента нету на лекции
	 * @return StudentPerformance [Attendance, Mark, Comment]*/
	public StudentPerformance getStudentPerformance(Student student) throws IllegalArgumentException {
		if (!students.containsKey(student)) {
			throw new IllegalArgumentException("Student not found in the lecture");
		}
		return students.get(student);
	}

	public boolean isStudentOnLecture(Student student) {
		return students.containsKey(student);
	}

	/** Отметить посещение студента на лекции
	 * @param student указатель на студента
	 * @param att 1: присутствовал, 0: опоздал -1: отсутствовал*/
	public void putAttendance(Student student, int att) {
		StudentPerformance curSP = getStudentPerformance(student);
		curSP.setAttendace(att);
	}

	/** Оставить оценку за лекцию
	 * @param student указатель на студента
	 * @param mark оценка за лекцию*/
	public void putMark(Student student, int mark) {
		StudentPerformance curSP = getStudentPerformance(student);
		curSP.putMark(mark);
	}

	/** Оставить комментарий о студента за лекцию
	 * @param student указатель на студента
	 * @param comment комментарий учителя */
	public void putComment(Student student, String comment) {
		StudentPerformance curSP = getStudentPerformance(student);
		curSP.addComment(comment);
	}

}