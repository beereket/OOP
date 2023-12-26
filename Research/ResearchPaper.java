package Research;

import java.util.List;

public class ResearchPaper {
    private String title;
    private List<Researcher> authors;
    private List<ResearchPaper> citations;
    private String doi;
    private Integer pages;
    private Integer publicationYear;
    private String publisher;
    private Integer accessionNumber;

    public ResearchPaper(String title, List<Researcher> authors, List<ResearchPaper> citations, String doi,
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

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public List<ResearchPaper> getCitations() {
        return citations;
    }
    public int getPages() {
        return pages;
    }
    public List<Researcher> getAuthors() {
        return authors;
    }


    public String getCitation(Research.Enums.Format format) throws Research.FormatNotSupportedException {
        return switch (format) {
            case PLAIN_TEXT -> generatePlainTextCitation();
            case BIBTEX -> generateBibtexCitation();
            default -> throw new Research.FormatNotSupportedException("Unsupported citation format: " + format);
        };
    }

    private String generatePlainTextCitation() {
        StringBuilder citationBuilder = new StringBuilder();
        citationBuilder.append("Title: ").append(title).append("\n");
        citationBuilder.append("Authors: ").append(formatAuthorsForPlainText()).append("\n");
        citationBuilder.append("Year: ").append(publicationYear).append("\n");
        // Add other relevant information to the plain text citation
        return citationBuilder.toString();
    }

    private String generateBibtexCitation() {
        StringBuilder citationBuilder = new StringBuilder();
        citationBuilder.append("@article{key,\n");
        citationBuilder.append("  author = {").append(formatAuthorsForBibtex()).append("},\n");
        citationBuilder.append("  title = {").append(title).append("},\n");
        citationBuilder.append("  year = {").append(publicationYear).append("},\n");
        // Add other relevant information to the BibTeX citation
        citationBuilder.append("}");

        return citationBuilder.toString();
    }

    private String formatAuthorsForPlainText() {
        // Format the list of authors as a comma-separated string
        StringBuilder authorsBuilder = new StringBuilder();
        for (Researcher author : authors) {
            authorsBuilder.append(author.getResearcherName()).append(", ");
        }
        // Remove the trailing comma and space
        if (authorsBuilder.length() > 0) {
            authorsBuilder.setLength(authorsBuilder.length() - 2);
        }
        return authorsBuilder.toString();
    }

    private String formatAuthorsForBibtex() {
        // Format the list of authors for BibTeX
        StringBuilder authorsBuilder = new StringBuilder();
        for (Researcher author : authors) {
            authorsBuilder.append(author.getResearcherName()).append(" and ");
        }
        // Remove the trailing "and" and space
        if (authorsBuilder.length() > 0) {
            authorsBuilder.setLength(authorsBuilder.length() - 5);
        }
        return authorsBuilder.toString();
    }

    
    public String toString() {
    	return title + "\n" + authors + "\n" + citations + "\n" + doi + "\n" + pages + "\n" + publicationYear + "\n" + publisher + "\n" + accessionNumber;
    }

}
