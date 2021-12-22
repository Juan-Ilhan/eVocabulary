package htw.berlin.webtech.web;

import htw.berlin.webtech.service.KarteiService;
import htw.berlin.webtech.web.api.Kartei;
import htw.berlin.webtech.web.api.KarteiManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class KarteiRestController {

    private final KarteiService karteiService;

    public KarteiRestController(KarteiService karteiService) {
        this.karteiService = karteiService;

    }




    @GetMapping(path = "/api/v1/karteikarten")
    public ResponseEntity<List<Kartei>> fetchKartei() {
        return ResponseEntity.ok(karteiService.findAll());

    }

    @GetMapping(path = "/api/v1/karteikarten/{id}")
    public ResponseEntity<Kartei> fetchKarteiById(@PathVariable Long id){

        var kartei = karteiService.findById(id);
        return kartei != null? ResponseEntity.ok(kartei) : ResponseEntity.notFound().build();


    }

    @PostMapping(path = "/api/v1/karteikarten")
    public ResponseEntity<Void> createKartei(@RequestBody KarteiManipulationRequest request) throws URISyntaxException {
      var kartei = karteiService.create(request);
        URI uri = new URI("/api/v1/karteikarten/" + kartei.getId());
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
