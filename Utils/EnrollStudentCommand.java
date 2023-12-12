package unite-4;


public class EnrollStudentCommand implements Command {
    
    private Student student;
    
    private Course course;
    
    
    
    
    private Student getStudent() {
        return this.student;
    }
    
    
    private Student setStudent(Student student) {
        this.student = student;
    }
    
    
    private Course getCourse() {
        return this.course;
    }
    
    
    private Course setCourse(Course course) {
        this.course = course;
    }
    

    //                          Operations                                  
    
    
}
