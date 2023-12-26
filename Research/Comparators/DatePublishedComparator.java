package Research.Comparators;

import Research.ResearchPaper;
import java.util.Comparator;
/**
 * A comparator for sorting research papers based on their publication year.
 * Papers published earlier will come first in the sorted order.
 */
public class DatePublishedComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPublicationYear(), paper2.getPublicationYear());
    }
}
