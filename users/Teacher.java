package users;

public class Teacher extends Employee {
    public Teacher(String ID, String username, String password, String position) {
        super(ID, username, password, position);
    }

    @Override
    public void sendComplaint() {

    }

    @Override
    public void viewCourses() {

    }

    @Override
    public void manageCourse() {

    }

    @Override
    public void viewStudents() {

    }

    @Override
    public void putMarks() {

    }

    @Override
    public void sendMessages() {

    }

    public void sendComplaintToDean() {
    }
}
