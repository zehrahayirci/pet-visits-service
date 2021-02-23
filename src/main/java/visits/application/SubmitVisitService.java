package visits.application;
import visits.OwnerVisitPost;
import visits.Visit;
import visits.VisitRepository;
import visits.VisitStatus;

/**
 * Created by zehra on 2/23/21.
 */
public class SubmitVisitService {

    private VisitRepository visitRepository;

    public SubmitVisitService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public void SaveVisit(Visit visit){
        this.visitRepository.save(visit);

    }
}
