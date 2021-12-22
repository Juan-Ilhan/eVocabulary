package htw.berlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "Karteikarten")
public class KarteiEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "german_word", nullable = false)
    private String germanWord;

    @Column(name = "english_word", nullable = false)
    private String englishWord;

    @Column(name = "definition")
    private String definition;

    public KarteiEntity(Long id, String germanWord, String englishWord, String definition) {
        this.id = id;
        this.germanWord = germanWord;
        this.englishWord = englishWord;
        this.definition = definition;
    }

    public KarteiEntity(String englishWord, String germanWord, String definition) {
    this(null,englishWord,germanWord,definition);
    }

    public KarteiEntity() {
        this(null,null,null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
