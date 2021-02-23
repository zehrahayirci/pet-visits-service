package visits.application;
import org.springframework.beans.factory.annotation.Autowired;
import visits.OwnerVisitPost;
import visits.Visit;
import visits.VisitRepository;
import visits.VisitStatus;

/**
 * Created by zehra on 2/23/21.
 */
public class SubmitVisitService {

    @Autowired
    private VisitRepository visitRepository;

    public SubmitVisitService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public Visit SaveVisit(Visit visit){
        return this.visitRepository.save(visit);
    }
}
