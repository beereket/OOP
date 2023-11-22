package users;

public abstract class Employee extends User {
    private String position;

    public Employee(String ID, String username, String password, String position) {
        super(ID, username, password);
        this.position = position;
    }

    public abstract void sendComplaint();

    public abstract void viewCourses();

    public abstract void manageCourse();

    public abstract void viewStudents();

    public abstract void putMarks();

    public abstract void sendMessages();
}
