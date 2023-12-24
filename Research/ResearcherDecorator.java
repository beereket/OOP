package Research;

import Research.Exceptions.CannotBecomeResearcherException;
import Users.*;

public class ResearcherDecorator implements Researcher {
    private final Researcher decoratedUser;

    public ResearcherDecorator(User user) throws CannotBecomeResearcherException {
        if (user instanceof Student || user instanceof Teacher || user instanceof Employee || user instanceof GraduateStudent) {
            this.decoratedUser = (Researcher) user;
        } else {
            throw new CannotBecomeResearcherException("Invalid user type for ResearcherDecorator");
        }
    }

    @Override
    public void printPapers() {
        decoratedUser.printPapers();
    }

    @Override
    public int calculateHIndex() {
        return decoratedUser.calculateHIndex();
    }

    @Override
    public String getResearcherName() {
        return decoratedUser.getResearcherName();
    }

    @Override
    public void setSupervisor(Researcher supervisor) throws Research.ResearchSupervisorException {
        decoratedUser.setSupervisor(supervisor);
    }

    @Override
    public void joinResearchProject(ResearchProject project) throws Research.ResearchProjectJoinException {
        decoratedUser.joinResearchProject(project);
    }

    @Override
    public void notify(String message) {
        decoratedUser.notify(message);
    }
}
