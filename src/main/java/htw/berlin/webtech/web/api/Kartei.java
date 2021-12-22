package htw.berlin.webtech.web.api;

public class Kartei {

    private long id;
    private String englishWord;
    private String germanWord;
    private String definition;

    public Kartei(long id, String englishWord, String germanWord, String definition) {
        this.id = id;
        this.englishWord = englishWord;
        this.germanWord = germanWord;
        this.definition = definition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public void setGermanWord(String germanWord) {
        this.germanWord = germanWord;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
