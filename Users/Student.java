package unite-4;


public class Student extends User implements Researcher, Observer {
    
    private Integer id;
    
    private Faculty faculty;
    
    private Integer yearOfStudy;
    private invalid coursesRegistered;
    
    private String transcript;
    
    private invalid attribute;
    
    private invalid attribute2;
    
    private Degree degree;
    
    private Boolean isResearcher;
    
    private StudentOrganization studentOrganization;
    
    private Integer credits;
    
    
    private StudentOrganization studentOrganization2;
    
    private Course course;
    
    
    
    private Integer getId() {
        return this.id;
    }
    
    
    private Integer setId(Integer id) {
        this.id = id;
    }
    
    
    private Faculty getFaculty() {
        return this.faculty;
    }
    
    
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    private Integer getYearOfStudy() {
        return this.yearOfStudy;
    }
    
    
    private Integer setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    
    private invalid getCoursesRegistered() {
        return this.coursesRegistered;
    }
    
    
    private invalid setCoursesRegistered(invalid coursesRegistered) {
        this.coursesRegistered = coursesRegistered;
    }
    
    
    private String getTranscript() {
        return this.transcript;
    }
    
    
    private String setTranscript(String transcript) {
        this.transcript = transcript;
    }
    
    
    private invalid getAttribute() {
        return this.attribute;
    }
    
    
    private invalid setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
    private invalid getAttribute2() {
        return this.attribute2;
    }
    
    
    private invalid setAttribute2(invalid attribute2) {
        this.attribute2 = attribute2;
    }
    
    
    private Degree getDegree() {
        return this.degree;
    }
    
    
    private Degree setDegree(Degree degree) {
        this.degree = degree;
    }
    
    
    private Boolean getIsResearcher() {
        return this.isResearcher;
    }
    
    
    private Boolean setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    
    
    private StudentOrganization getStudentOrganization() {
        return this.studentOrganization;
    }
    
    
    private StudentOrganization setStudentOrganization(StudentOrganization studentOrganization) {
        this.studentOrganization = studentOrganization;
    }
    
    
    private Integer getCredits() {
        return this.credits;
    }
    
    
    private Integer setCredits(Integer credits) {
        this.credits = credits;
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
