package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.PersonEntity;
import htw.berlin.webtech.persistence.PersonRepository;
import htw.berlin.webtech.web.api.Person;
import htw.berlin.webtech.web.api.PersonManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KarteiService {

    private final KarteiRepository karteiRepository;

    public KarteiService(KarteiRepository karteiRepository) {
        this.karteiRepository = karteiRepository;
    }
    public List<Kartei>findAll(){

        List<KarteiEntity> Karteikarten = karteiRepository.findAll();
        return karteikarten.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Kartei findById(Long id){

        var karteiEntity = karteiRepository.findById(id);
        return karteiEntity.map(this::transformEntity).orElse(null);
    }

    public Kartei create(KarteiManipulationRequest request){

        var karteiEntity = new KarteiEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());

        karteiEntity = karteiRepository.save(karteiEntity);
        return transformEntity(karteiEntity);
    }

    public Kartei update(Long id, KarteiManipulationRequest request){

        var karteiEntityOptional = karteiRepository.findById(id);

        if(karteiEntityOptional.isEmpty()){
            return null;
        }

        var karteiEntity= karteiEntityOptional.get();
        karteiEntity.setFirstName(request.getFirstName());
        karteiEntity.setLastName(request.getLastName());
        karteiEntity.setVaccinated(request.isVaccinated());
        karteiEntity = karteiRepository.save(personEntity);

        return transformEntity(karteiEntity);
    }
    public boolean deleteById(Long id) {
        if (!karteiRepository.existsById(id)) {
            return false;
        }

        karteiRepository.deleteById(id);
        return true;
    }


    private Kartei transformEntity(KarteiEntity karteiEntity){

        return new Kartei(

                karteiEntity.getId(),
                karteiEntity.getFirstName(),
                karteiEntity.getLastName(),
                karteiEntity.isVaccinated()
        );
    }
}
