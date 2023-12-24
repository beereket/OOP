package Academic;

import Academic.Enums.*;
import Users.Student;

import java.io.Serializable;

public class Journal implements Serializable {
	public void putMark(Student student , Course course , int mark , typeOfAttestation type){
		course.putMark(student, type, mark);
	}
	public void putMark(Student student , Lesson lesson , int mark){
		lesson.putMark(student, mark); //
	}

	public void putAttendance(Student student, Lesson lesson, int att){
		lesson.putAttendance(student, att);
	}
	public void putComment(Student student, Lesson lesson, String comment){
		lesson.putComment(student, comment);
	}
}
