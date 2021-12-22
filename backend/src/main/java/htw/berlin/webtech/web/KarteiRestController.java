package htw.berlin.webtech.web;

import htw.berlin.webtech.service.PersonService;
import htw.berlin.webtech.web.api.Person;
import htw.berlin.webtech.web.api.PersonManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class KarteiRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;

    }




    @GetMapping(path = "/api/v1/karteikarten")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());

    }

    @GetMapping(path = "/api/v1/karteikarten/{id}")
    public ResponseEntity<Kartei> fetchKarteiById(@PathVariable Long id){

        var kartei = karteiService.findById(id);
        return kartei != null? ResponseEntity.ok(kartei) : ResponseEntity.notFound().build();


    }

    @PostMapping(path = "/api/v1/karteikarten")
    public ResponseEntity<Void> createPerson(@RequestBody KarteiManipulationRequest request) throws URISyntaxException {
      var kartei = karteiService.create(request);
        URI uri = new URI("/api/v1/persons/" + kartei.getId());
      return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/karteikarten/{id}")
    public ResponseEntity<Kartei> updateKartei(@PathVariable Long id, @RequestBody KarteiManipulationRequest request){
        var kartei = karteiService.update(id, request);
        return kartei != null? ResponseEntity.ok(kartei) : ResponseEntity.notFound().build();


    }
    @DeleteMapping(path = "/api/v1/karteikarten/{id}")
    public ResponseEntity<Void> deleteKartei(@PathVariable Long id) {
        boolean successful = karteiService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
