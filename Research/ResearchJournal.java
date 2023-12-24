package Research;

import Util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResearchJournal implements Serializable {
    protected String name;
    private List<Observer> subscribers = new ArrayList<>();
    private List<ResearchPaper> papers = new ArrayList<>();
    
    public ResearchJournal(String name) {
        this.name = name;
    }

    public void subscribe(Observer observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
        }
    }

    public void unsubscribe(Observer observer) {
    	subscribers.remove(observer);
    }

    public void publishNewPaper(ResearchPaper paper) {
        papers.add(paper);
        System.out.println("New paper published in " + name + ": " + paper.getTitle());
        notifySubscribers(paper.getTitle());
    }

    private void notifySubscribers(String paperTitle) {
        for (Observer subscriber : subscribers) {
            subscriber.update(name, paperTitle);
        }
    }
    
    public String toString() {
    	return name + "\n" + subscribers;
    }

}
