package htw.berlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "Karteikarten")
public class KarteiEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "german_word", nullable = false)
    private String germanWord;

    @Column(name = "english_word", nullable = false)
    private String englishWord;

    @Column(name = "definition")
    private String definition;

    public KarteiEntity(long id, String germanWord, String englishWord, String definition) {
        this.id = id;
        this.germanWord = germanWord;
        this.englishWord = englishWord;
        this.definition = definition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public void setGermanWord(String germanWord) {
        this.germanWord = germanWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
