package visits.application;

import visits.Visit;
import visits.VisitRepository;

import java.util.List;

/**
 * Created by zehra on 2/23/21.
 */
public class ListVisitService {

    private VisitRepository visitRepository;

    public ListVisitService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public List<Visit> ListbyOwner(int ownerId){
        return visitRepository.findAllByOwnerId(ownerId);

    }

    public Visit ListbyId(int visitId){
        return visitRepository.findById(visitId);

    }
}
