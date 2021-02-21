package visits;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface VisitRepository extends Repository<Visit, Long> {

    Visit findById(int id);

    List<Visit> findAllByOwnerId(int ownerId);

    Visit save(Visit visit);

}
