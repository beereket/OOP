package Research;

import java.io.*;
import java.util.List;

public class ResearchPaper implements Serializable {
    private static final long serialVersionUID = 1L;
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

        saveToFile();
    }
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("research_papers.dat", true))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Researcher> getAuthors() {
        return authors;
    }

    public List<ResearchPaper> getAllCitations() {
        return citations;    }


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
