package Research;

import java.util.List;

public class ResearchPaper {
    private String title;
    private List<Researcher> authors;
    private String citations;
    private String doi;
    private Integer pages;
    private Integer publicationYear;
    private String publisher;
    private Integer accessionNumber;

    public ResearchPaper(String title, List<Researcher> authors, String citations, String doi,
                         Integer pages, Integer publicationYear, String publisher, Integer accessionNumber) {
        this.title = title;
        this.authors = authors;
        this.citations = citations;
        this.doi = doi;
        this.pages = pages;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.accessionNumber = accessionNumber;
    }


    public String getCitation(Research.Format format) throws Research.FormatNotSupportedException {
        return switch (format) {
            case PLAIN_TEXT -> generatePlainTextCitation();
            case BIBTEX -> generateBibtexCitation();
            default -> throw new Research.FormatNotSupportedException("Unsupported citation format: " + format);
        };
    }

    private String generatePlainTextCitation() {
        // Implement plain text citation generation logic
        return "Plain text citation";
    }

    private String generateBibtexCitation() {
        // Implement BibTeX citation generation logic
        return "@article{key, author = {...}, title = {...}, ...}";
    }

    
    public String toString() {
    	return title + "\n" + authors + "\n" + citations + "\n" + doi + "\n" + pages + "\n" + publicationYear + "\n" + publisher + "\n" + accessionNumber;
    }

}
