package unite-4;


public class Admin extends User {
    
    private String logFiles;
    
    private String getLogFiles() {
        return this.logFiles;
    }
    
    
    private String setLogFiles(String logFiles) {
        this.logFiles = logFiles;
    }
    

    public String viewLogFiles() {
        return "";
    }

    public User createUser() {
        return null;
    }

    
    
}
