package Academic;

import Academic.Enums.SemesterType;
import Academic.Enums.typeOfAttestation;
import Users.Enums.Faculty;
import Users.Student;
import Users.Teacher;
import Util.Classes.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Course implements Serializable {
	private String code;
	private String title;
	private String description;
	private int credits;
	private String courseType;
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

		Data.getInstance().addCourse(this);
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
	public void setStudents(Collection<Student> students) {
		for(Student student: students){
			this.students.put(student, new Mark());
		}
	}
	public HashSet<Teacher> getInstructors() {
		return instructors;
	}
	public void setInstructors(Collection<Teacher> instructors) {
		this.instructors = new HashSet<>(instructors);
	}
	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(Collection<Course> prerequisites) {
		this.prerequisites = new HashSet<>(prerequisites);
	}
	public void setLessons(Collection<Lesson> lessons){
		this.lessons = new HashSet<>(lessons);
	}
	public void addLesson(Lesson lesson){
		this.lessons.add(lesson);
	}
	
					/* 				Operatios				*/

	/** Выставить оценки за аттестацию/Файнал
	 * Меняет прикрепленный Mark студента на заданный параметром
	 * @param student указатель на студента
	 * @param type Первая/Вторая аттестация или же Файнал
	 * @param mark общая оценка за аттестацию*/
	public void putMark(Student student, typeOfAttestation type, int mark) {
		Mark curMark = students.get(student);
		curMark.putMark(type, mark);
	}

	/**  Журнал обущающегося в WSP по кнопку 'Итог'.
	 *   Пробегается по всем лекциям курса в которым присуствует студент
	 *   и возвращает данные в качестве массива размером 3 [Оценки,Присуствие,Отсутствие]
	 * @param student указатель на студента
	 * */
	public double[] sumStudentLectureInfo(Student student){
		double sumMarks = 0;

		double sumAbsent = 0;
		int sumPresent = 0;

		try {
			for (Lesson lesson : lessons) {
				StudentPerformance curSP = lesson.getStudentPerformance(student);

				if (curSP != null) {
					sumMarks += curSP.getMark();

					switch (curSP.getAttendace()) {
						case 1 : sumPresent += 1;
						case 0 : sumAbsent += 0.5;
						case -1: sumAbsent += 1;
					}
				}
			}
		}
		catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}

		return new double[]{sumMarks, sumPresent, sumAbsent};
	}

	@Override
	public String toString() {
		return "Course{" +
				"code='" + code + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", credits=" + credits +
				", courseType='" + courseType + '\'' +
				", semesterNum=" + semesterNum +
				", semesterType=" + semesterType +
				", faculty=" + faculty +
				'}';
	}
}
