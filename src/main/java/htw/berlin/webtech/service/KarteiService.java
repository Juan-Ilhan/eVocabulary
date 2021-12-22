package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.KarteiEntity;
import htw.berlin.webtech.persistence.KarteiRepository;
import htw.berlin.webtech.web.api.Kartei;
import htw.berlin.webtech.web.api.KarteiManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KarteiService {
    @Autowired
    private final KarteiRepository karteiRepository;

    public KarteiService(KarteiRepository karteiRepository) {
        this.karteiRepository = karteiRepository;
    }
    public List<Kartei>findAll(){

        List<KarteiEntity> karteikarten = karteiRepository.findAll();
        return karteikarten.stream() //Kartei vlt klein geschrieben?!
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Kartei findById(Long id){

        var karteiEntity = karteiRepository.findById(id);
        return karteiEntity.map(this::transformEntity).orElse(null);
    }

    public Kartei create(KarteiManipulationRequest request){

        var karteiEntity = new KarteiEntity(request.getEnglishWord(), request.getGermanWord(), request.getDefinition());

        karteiEntity = karteiRepository.save(karteiEntity);
        return transformEntity(karteiEntity);
    }

    public Kartei update(Long id, KarteiManipulationRequest request){

        var karteiEntityOptional = karteiRepository.findById(id);

        if(karteiEntityOptional.isEmpty()){
            return null;
        }

        var karteiEntity= karteiEntityOptional.get();
        karteiEntity.setEnglishWord(request.getEnglishWord());
        karteiEntity.setGermanWord(request.getGermanWord());
        karteiEntity.setDefinition(request.getDefinition());
        karteiEntity = karteiRepository.save(karteiEntity);

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
                karteiEntity.getEnglishWord(),
                karteiEntity.getGermanWord(),
                karteiEntity.getDefinition()
        );
    }
}
