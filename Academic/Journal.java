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

	public void menu(){
		// List teacher.getCourseTaught()
		// teacher chooses one course (c)
		// teacher chooses putMark() on attestation OR putMark/Attendance/Comment on lecture
		// case attestation: putMark(Student student , Course course , int mark , typeOfAttestation type)
		// case lecture: List course.getLectures()
		// teachers chooses one lecture
		// teacher types a id or some identifer for student
		// teacher chooses what to do -> 1: putMark 2: putAttendance 3: putComment
		// for each case there's a function;
	}
}
