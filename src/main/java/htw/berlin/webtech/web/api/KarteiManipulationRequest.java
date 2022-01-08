package htw.berlin.webtech.web.api;

import javax.validation.constraints.NotBlank;

public class KarteiManipulationRequest {

    @NotBlank(message = "Bitte mindestens einen Buchstaben eingeben.")
    private String germanWord;

    @NotBlank(message = "Das Übersetzungsfeld darf nicht leer bleiben.")
    private String englishWord;

    @NotBlank(message = "Das Definitionsfeld darf nicht leer bleiben.")
    private String definition;

    public KarteiManipulationRequest(){}

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
