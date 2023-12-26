package Research.Comparators;

import Research.ResearchPaper;
import java.util.Comparator;
/**
 * A comparator for sorting research papers based on their article length (number of pages).
 * Papers with fewer pages will come first in the sorted order.
 */
public class ArticleLengthComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPages(), paper2.getPages());
    }
}
