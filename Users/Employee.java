package unite-4;



public class Employee extends User {
    
    private Integer id;
    private String position;

    private Integer getId() {
        return this.id;
    }
    
    
    private Integer setId(Integer id) {
        this.id = id;
    }
    
    
    private String getPosition() {
        return this.position;
    }
    
    
    private String setPosition(String position) {
        this.position = position;
    }
    
}
