package htw.berlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KarteiRepository extends JpaRepository<KarteiEntity, Long> {


}
