package Research.Comparators;

import Research.ResearchPaper;

import java.util.Comparator;

public class ArticleLengthComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPages(), paper2.getPages());
    }
}
