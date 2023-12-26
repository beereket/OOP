package Research;

import Util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a research journal in the university system.
 * Research journals publish research papers and can have subscribers.
 */
public class ResearchJournal implements Serializable {
    protected String name;
    private List<Observer> subscribers = new ArrayList<>();
    private List<ResearchPaper> papers = new ArrayList<>();
    /**
     * Constructs a ResearchJournal with the specified name.
     *
     * @param name The name of the ResearchJournal.
     */
    public ResearchJournal(String name) {
        this.name = name;
    }

    /**
     * Subscribes an observer to receive notifications about new papers published in the journal.
     *
     * @param observer The observer to be subscribed.
     */
    public void subscribe(Observer observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
        }
    }

    /**
     * Unsubscribes an observer from receiving notifications about new papers.
     *
     * @param observer The observer to be unsubscribed.
     */
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    /**
     * Publishes a new research paper in the journal and notifies all subscribers.
     *
     * @param paper The ResearchPaper to be published.
     */
    public void publishNewPaper(ResearchPaper paper) {
        papers.add(paper);
        System.out.println("New paper published in " + name + ": " + paper.getTitle());
        notifySubscribers(paper.getTitle());
    }

    /**
     * Notifies all subscribers about a new paper being published.
     *
     * @param paperTitle The title of the published paper.
     */
    private void notifySubscribers(String paperTitle) {
        for (Observer subscriber : subscribers) {
            subscriber.update(name, paperTitle);
        }
    }

    /**
     * Returns a string representation of the ResearchJournal.
     *
     * @return A string representation including the name and subscribers.
     */
    @Override
    public String toString() {
        return name + "\n" + subscribers;
    }

    /**
     * Checks if this ResearchJournal is equal to another object.
     *
     * Two ResearchJournals are considered equal if they have the same name.
     *
     * @param obj The object to compare with this ResearchJournal.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResearchJournal that = (ResearchJournal) obj;
        return Objects.equals(name, that.name);
    }

    /**
     * Returns the hash code value for this ResearchJournal.
     *
     * The hash code is based on the name of the ResearchJournal.
     *
     * @return The hash code value for this ResearchJournal.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
