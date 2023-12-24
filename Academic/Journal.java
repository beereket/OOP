package Academic;

import Academic.Enums.*;
import Users.Student;

import java.io.Serializable;

public class Journal implements Serializable {

	public void putMarks(Student student, typeOfAttestation type, int mark, Course course){
		course.putMark(student, type, mark);
	}
	public void putAttendance(Student student, Lesson lesson, int att){
		lesson.setAttendance(student, att);
	}
	public void putComment(Student student, String comment, Course course){

	}
}
