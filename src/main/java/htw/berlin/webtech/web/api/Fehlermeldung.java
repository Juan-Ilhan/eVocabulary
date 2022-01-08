package htw.berlin.webtech.web.api;

import javax.validation.constraints.NotBlank;

public class Fehlermeldung {

    @NotBlank(message = "Bitte mindestens einen Buchstaben eingeben.")
    private String germanword;

    @NotBlank(message = "Das Übersetzungsfeld darf nicht leer bleiben.")
    private String englishword;

    @NotBlank(message = "Das Definitionsfeld darf nicht leer bleiben.")
    private String definition;
}
