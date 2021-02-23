package visits.application;

import visits.domain.Visit;
import visits.domain.VisitRepository;
import visits.domain.VisitStatus;

public class UpdateVisitStatusService {
    private VisitRepository visitRepository;

    public UpdateVisitStatusService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    public Visit updateStatus(int visitId, int vetId, VisitStatus status) throws IllegalAccessException {
        Visit visit = visitRepository.findById(visitId);

        if(visit.getVetId() != vetId){
            throw new IllegalAccessException("The given vet does not manage this visit.");
        }
        
        visit.setStatus(status);
        return visit;
    }
}
