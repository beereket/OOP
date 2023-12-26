package Research;

import Research.Exceptions.FormatNotSupportedException;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
/**
 * A class representing a research paper in the university system.
 * Research papers are scholarly articles written by researchers.
 */
public class ResearchPaper implements Serializable {
    private static final String FILE_PATH = "researchPaperDB.dat";
    private String title;
    private List<Researcher> authors;
    private List<ResearchPaper> citations;
    private String doi;
    private Integer pages;
    private Integer publicationYear;
    private String publisher;
    private Integer accessionNumber;

    /**
     * Constructs a ResearchPaper with the specified attributes and automatically saves it to the file.
     *
     * @param title             The title of the research paper.
     * @param authors           The list of researchers who authored the paper.
     * @param citations         The list of research papers that this paper cites.
     * @param doi               The Digital Object Identifier of the paper.
     * @param pages             The number of pages in the paper.
     * @param publicationYear   The year the paper was published.
     * @param publisher         The publisher of the paper.
     * @param accessionNumber   The accession number of the paper.
     */
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

    /**
     * Gets the title of the research paper.
     *
     * @return The title of the research paper.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Gets the publication year of the research paper.
     *
     * @return The publication year of the research paper.
     */
    public int getPublicationYear() {
        return publicationYear;
    }
    /**
     * Gets the list of research papers that this paper cites.
     *
     * @return The list of research papers that this paper cites.
     */
    public List<ResearchPaper> getCitations() {
        return citations;
    }
    /**
     * Gets the number of pages in the research paper.
     *
     * @return The number of pages in the research paper.
     */
    public int getPages() {
        return pages;
    }
    /**
     * Gets the list of researchers who authored the paper.
     *
     * @return The list of researchers who authored the paper.
     */
    public List<Researcher> getAuthors() {
        return authors;
    }

    /**
     * Saves the ResearchPaper object to the file.
     */
    private void saveToFile() {
        List<ResearchPaper> allResearchPapers = loadAllResearchPapers();
        allResearchPapers.add(this);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(allResearchPapers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all ResearchPaper objects from the file.
     *
     * @return The list of all ResearchPaper objects loaded from the file.
     */
    public static List<ResearchPaper> loadAllResearchPapers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<ResearchPaper>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Generates a citation for the research paper in the specified format.
     *
     * @param format The desired format of the citation.
     * @return The citation string.
     * @throws FormatNotSupportedException If the specified citation format is not supported.
     */
    public String Citate(Research.Enums.Format format) throws FormatNotSupportedException {
        return switch (format) {
            case PLAIN_TEXT -> generatePlainTextCitation();
            case BIBTEX -> generateBibtexCitation();
            default -> throw new Research.Exceptions.FormatNotSupportedException("Unsupported citation format: " + format);
        };
    }

    /**
     * Generates a plain text citation for the research paper.
     *
     * @return A plain text citation including title, authors, and year.
     */
    private String generatePlainTextCitation() {
        StringBuilder citationBuilder = new StringBuilder();
        citationBuilder.append("Title: ").append(title).append("\n");
        citationBuilder.append("Authors: ").append(formatAuthorsForPlainText()).append("\n");
        citationBuilder.append("Year: ").append(publicationYear).append("\n");
        // Add other relevant information to the plain text citation
        return citationBuilder.toString();
    }
    /**
     * Generates a BibTeX citation for the research paper.
     *
     * @return A BibTeX citation formatted for referencing in LaTeX documents.
     */
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
    /**
     * Formats the list of authors for plain text representation.
     *
     * @return A formatted string containing the list of authors for plain text.
     */
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

    /**
     * Formats the list of authors for BibTeX representation.
     *
     * @return A formatted string containing the list of authors for BibTeX.
     */
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

    /**
     * Indicates whether some other ResearchPaper object is "equal to" this one.
     *
     * @param obj The reference ResearchPaper object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResearchPaper that = (ResearchPaper) obj;
        return Objects.equals(title, that.title) &&
                Objects.equals(authors, that.authors) &&
                Objects.equals(citations, that.citations) &&
                Objects.equals(doi, that.doi) &&
                Objects.equals(pages, that.pages) &&
                Objects.equals(publicationYear, that.publicationYear) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(accessionNumber, that.accessionNumber);
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, authors, citations, doi, pages, publicationYear, publisher, accessionNumber);
    }
    /**
     * Returns a string representation of the ResearchPaper.
     *
     * @return A string representation including the title, authors, citations, and other details.
     */
    public String toString() {
    	return title + "\n" + authors + "\n" + citations + "\n" + doi + "\n" + pages + "\n" + publicationYear + "\n" + publisher + "\n" + accessionNumber;
    }
}
