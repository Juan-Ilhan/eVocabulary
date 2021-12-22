package htw.berlin.webtech.web.api;

public class KarteiManipulationRequest {

    private String englishWord;
    private String germanWord;
    private String definition;

    public KarteiManipulationRequest(String englishWord, String germanWord, String definition) {
        this.englishWord = englishWord;
        this.germanWord = germanWord;
        this.definition = definition;
    }

    public KarteiManipulationRequest(){

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
