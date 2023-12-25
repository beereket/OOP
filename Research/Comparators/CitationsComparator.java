package Research.Comparators;

import Research.ResearchPaper;

import java.util.Comparator;

public class CitationsComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitations().size(), paper2.getCitations().size());
    }
}
