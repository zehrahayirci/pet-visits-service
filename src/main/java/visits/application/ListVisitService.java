package visits.application;

import org.springframework.beans.factory.annotation.Autowired;
import visits.infrastructure.data.VisitEntity;
import visits.infrastructure.data.VisitEntitySpringRepository;

import java.util.List;

/**
 * Created by zehra on 2/23/21.
 */
public class ListVisitService {

    @Autowired
    private VisitEntitySpringRepository visitEntitySpringRepository;

    public ListVisitService(VisitEntitySpringRepository visitEntitySpringRepository){
        this.visitEntitySpringRepository = visitEntitySpringRepository;
    }

    public List<VisitEntity> ListbyOwner(int ownerId){
        return visitEntitySpringRepository.findAllByOwnerId(ownerId);

    }

    public VisitEntity ListbyId(int visitId){
        return visitEntitySpringRepository.findById(visitId);

    }
}
