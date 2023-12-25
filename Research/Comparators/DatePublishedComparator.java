package Research.Comparators;

import Research.ResearchPaper;

import java.util.Comparator;

public class DatePublishedComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPublicationYear(), paper2.getPublicationYear());
    }
}
