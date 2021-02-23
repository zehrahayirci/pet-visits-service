package visits.infrastructure.database;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface VisitEntitySpringRepository extends Repository<VisitEntity, Long> {

    VisitEntity findById(int id);

    List<VisitEntity> findAllByOwnerId(int ownerId);

    VisitEntity save(VisitEntity visitEntity);

}
