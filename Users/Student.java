package unite;


/**
* @generated
*/
public class Student extends User implements Researcher, Observer {
    
    /**
    * @generated
    */
    private int id;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    /**
    * @generated
    */
    private int yearOfStudy;
    
    /**
    * @generated
    */
    private  coursesRegistered;
    
    /**
    * @generated
    */
    private String transcript;
    
    /**
    * @generated
    */
    private  attribute;
    
    /**
    * @generated
    */
    private  attribute2;
    
    /**
    * @generated
    */
    private Degree degree;
    
    /**
    * @generated
    */
    private boolean isResearcher;
    
    /**
    * @generated
    */
    private StudentOrganization studentOrganization;
    
    /**
    * @generated
    */
    private int credits;
    
    
    /**
    * @generated
    */
    private Course course;
    
    /**
    * @generated
    */
    private StudentOrganization studentOrganization2;
    
    

    /**
    * @generated
    */
    private int getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    private int setId(Integer id) {
        this.id = id;
    }
    
    
    /**
    * @generated
    */
    private Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    /**
    * @generated
    */
    private int getYearOfStudy() {
        return this.yearOfStudy;
    }
    
    /**
    * @generated
    */
    private int setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    
    /**
    * @generated
    */
    private  getCoursesRegistered() {
        return this.coursesRegistered;
    }
    
    /**
    * @generated
    */
    private  setCoursesRegistered(invalid coursesRegistered) {
        this.coursesRegistered = coursesRegistered;
    }
    
    
    /**
    * @generated
    */
    private String getTranscript() {
        return this.transcript;
    }
    
    /**
    * @generated
    */
    private String setTranscript(String transcript) {
        this.transcript = transcript;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute() {
        return this.attribute;
    }
    
    /**
    * @generated
    */
    private  setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute2() {
        return this.attribute2;
    }
    
    /**
    * @generated
    */
    private  setAttribute2(invalid attribute2) {
        this.attribute2 = attribute2;
    }
    
    
    /**
    * @generated
    */
    private Degree getDegree() {
        return this.degree;
    }
    
    /**
    * @generated
    */
    private Degree setDegree(Degree degree) {
        this.degree = degree;
    }
    
    
    /**
    * @generated
    */
    private boolean getIsResearcher() {
        return this.isResearcher;
    }
    
    /**
    * @generated
    */
    private boolean setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    
    
    /**
    * @generated
    */
    private StudentOrganization getStudentOrganization() {
        return this.studentOrganization;
    }
    
    /**
    * @generated
    */
    private StudentOrganization setStudentOrganization(StudentOrganization studentOrganization) {
        this.studentOrganization = studentOrganization;
    }
    
    
    /**
    * @generated
    */
    private int getCredits() {
        return this.credits;
    }
    
    /**
    * @generated
    */
    private int setCredits(Integer credits) {
        this.credits = credits;
    }
    
    
    
    /**
    * @generated
    */
    public Course getCourse() {
        return this.course;
    }
    
    /**
    * @generated
    */
    public Course setCourse(Course course) {
        this.course = course;
    }
    
    
    /**
    * @generated
    */
    public StudentOrganization getStudentOrganization2() {
        return this.studentOrganization2;
    }
    
    /**
    * @generated
    */
    public StudentOrganization setStudentOrganization2(StudentOrganization studentOrganization2) {
        this.studentOrganization2 = studentOrganization2;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public List<Course> viewCources() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean requestEnrollment() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public String getTranscript() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public List<Student> createStatisticalReport() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean requestRemovalCourse() {
        //TODO
        return false;
    }
    
    
}
