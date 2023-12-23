package Academic;

public class StudentPerformance {
    private int attendace;
    private int mark;
    private String comment;

    public StudentPerformance(){

    }
    public StudentPerformance(int attendace, int mark, String comment){
        this.attendace = attendace;
        this.mark = mark;
        this.comment = comment;
    }

    public int getAttendace() {
        return attendace;
    }

    public void setAttendace(int attendace) {
        this.attendace = attendace;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
