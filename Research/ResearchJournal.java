package Research;

import java.util.*;

public class ResearchJournal {
    protected String name;
    private List<Researcher> subscribers = new ArrayList<>();
    
    public ResearchJournal(String name) {
        this.name = name;
    }

    public void subscribe(Researcher researcher) {
        if (!subscribers.contains(researcher)) {
            subscribers.add(researcher);
        }
    }

    public void unsubscribe(Researcher researcher) {
    	subscribers.remove(researcher);
    }

    public void notifySubscribers() {
        for (Researcher subscriber : subscribers) {
            subscriber.notify("New research published in " + name);
        }
    }
    
    public String toString() {
    	return name + "\n" + subscribers;
    }

}
