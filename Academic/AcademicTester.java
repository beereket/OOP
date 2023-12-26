package Academic;

import Academic.Enums.LessonType;
import Academic.Enums.SemesterType;
import Academic.Enums.typeOfAttestation;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Users.Enums.Title;
import Users.Student;
import Users.Teacher;
import Util.Enums.UserType;

import java.time.LocalTime;
import java.util.ArrayList;

public class AcademicTester {
    public static void main(String[] args){
        Course oop = new Course("INFT2305", "OOP", "Object-Oriented Programming", 5,
                "201", SemesterType.FALL, Faculty.SITE);

        Teacher pakita = new Teacher("s_pakita" , "pass3", Title.SENIOR);

        Journal journal = new Journal();

        Student askar = new Student("a_zhumabayev", "pass", Faculty.SEPI, Degree.BACHELOR);
        Student ayan = new Student("a_omarivich", "pass2" , Faculty.BS, Degree.BACHELOR);

        ArrayList<Student> students =  new ArrayList<Student>();
        students.add(askar); students.add(ayan);

        Lesson lecture1 = new Lesson(LessonType.Lecture, LocalTime.of(12, 00),1,
                pakita, 444, 2, true, students);

        journal.putMark(askar, lecture1, 2);
        journal.putMark(askar, lecture1, 2);
        journal.putMark(askar, lecture1, 5);
        journal.putMark(askar, lecture1, 3);

        journal.putAttendance(askar, lecture1, -1);
        journal.putAttendance(askar, lecture1, -1);
        journal.putAttendance(askar, lecture1,  1);

        oop.addLesson(lecture1);

        double[] temp = oop.sumStudentLectureInfo(askar);

        for(double value: temp){
//            System.out.println(value);
        }
        oop.addStudent(askar);

        journal.putMark(askar, oop, 25, typeOfAttestation.FIRST);
        journal.putMark(askar, oop, 25, typeOfAttestation.SECOND);
        journal.putMark(askar, oop, 35, typeOfAttestation.FINAL);

        System.out.println(oop.getStudentMark(askar));

    }
}
