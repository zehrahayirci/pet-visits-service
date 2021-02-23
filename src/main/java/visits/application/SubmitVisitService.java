package visits.application;
import org.springframework.beans.factory.annotation.Autowired;
import visits.infrastructure.database.VisitEntity;
import visits.infrastructure.database.VisitEntitySpringRepository;

/**
 * Created by zehra on 2/23/21.
 */
public class SubmitVisitService {

    @Autowired
    private VisitEntitySpringRepository visitEntitySpringRepository;

    public SubmitVisitService(VisitEntitySpringRepository visitEntitySpringRepository){
        this.visitEntitySpringRepository = visitEntitySpringRepository;
    }

    public VisitEntity SaveVisit(VisitEntity visitEntity){
        return this.visitEntitySpringRepository.save(visitEntity);
    }
}
