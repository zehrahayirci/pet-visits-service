package visits.application;
import org.springframework.beans.factory.annotation.Autowired;
import visits.domain.Visit;
import visits.domain.VisitRepository;
import visits.infrastructure.data.VisitEntity;
import visits.infrastructure.data.VisitEntitySpringRepository;

/**
 * Created by zehra on 2/23/21.
 */
public class SubmitVisitService {

    private VisitRepository visitRepository;

    public SubmitVisitService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public Visit SaveVisit(Visit visit){
        return this.visitRepository.save(visit);
    }
}
