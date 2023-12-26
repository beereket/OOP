package Research.Comparators;

import Research.ResearchPaper;
import java.util.Comparator;
/**
 * A comparator for sorting research papers based on the number of citations they have.
 * Papers with more citations will come first in the sorted order.
 */
public class CitationsComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitations().size(), paper2.getCitations().size());
    }
}
