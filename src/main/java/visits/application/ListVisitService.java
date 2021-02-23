package visits.application;

import org.springframework.beans.factory.annotation.Autowired;
import visits.domain.Visit;
import visits.domain.VisitRepository;
import visits.infrastructure.data.VisitEntity;
import visits.infrastructure.data.VisitEntitySpringRepository;

import java.util.List;

/**
 * Created by zehra on 2/23/21.
 */
public class ListVisitService {

    private VisitRepository visitRepository;

    public ListVisitService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public List<Visit> listbyOwner(int ownerId){
        return visitRepository.findAllByOwnerId(ownerId);

    }

    public Visit listbyId(int visitId){
        return visitRepository.findById(visitId);

    }
}
