package visits.domain;

import visits.domain.Visit;

import java.util.List;

public interface VisitRepository {
    visits.Visit findById(int id);

    List<visits.Visit> findAllByOwnerId(int ownerId);

    visits.Visit save(Visit visit);
}
