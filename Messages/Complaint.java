package Messages;

import Messages.enums.UrgencyLevel;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;

public class Complaint implements Serializable {
    private Student student;
    private String description;
    private UrgencyLevel urgencyLevel;
    private Teacher complainant;
    //
    public Complaint(Student student,String description, UrgencyLevel urgencyLevel, Teacher complainant) {
        this.student = student;
        this.description = description;
        this.urgencyLevel = urgencyLevel;
        this.complainant = complainant;
    }

    public String getDescription() {
        return description;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    public Teacher getComplainant() {
        return complainant;
    }

}
