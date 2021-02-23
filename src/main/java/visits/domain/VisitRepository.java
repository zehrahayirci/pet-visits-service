package visits.domain;

import java.util.List;

public interface VisitRepository {
    Visit findById(int id);

    List<Visit> findAllByOwnerId(int ownerId);

    Visit save(Visit visit);
}
