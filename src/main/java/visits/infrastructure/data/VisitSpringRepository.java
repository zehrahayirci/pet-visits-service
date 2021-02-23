package visits.infrastructure.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import visits.domain.Visit;
import visits.domain.VisitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VisitSpringRepository implements VisitRepository {

    @Autowired
    private VisitToVisitEntityMapper mapper;

    @Autowired
    VisitEntitySpringRepository entityRepository;

    @Override
    public Visit findById(int id) {
        return mapper.mapToVisit(entityRepository.findById(id));
    }

    @Override
    public List<Visit> findAllByOwnerId(int ownerId) {
        return entityRepository.findAllByOwnerId(ownerId)
                .stream()
                .map(visitEntity -> mapper.mapToVisit(visitEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Visit save(Visit visit) {
        VisitEntity visitEntity = mapper.mapToVisitEntity(visit);
        visitEntity = entityRepository.save(visitEntity);
        return mapper.mapToVisit(visitEntity);
    }
}
