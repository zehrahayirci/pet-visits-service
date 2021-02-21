package visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class VisitsController {

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<Visit>> getVisits(
            @PathVariable("ownerId") int ownerId) {
        return ResponseEntity.ok(visitRepository.findAllByOwnerId(ownerId));
    }

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<Visit> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView) {
        Visit visit = OwnerVisitPost.toVisit(ownerVisitView, ownerId, VisitStatus.PENDING);
        return ResponseEntity.ok(visitRepository.save(visit));
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<Visit> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        Visit visit = visitRepository.findById(visitId);
        if (visit.getVetId() != vetId) {
            return ResponseEntity.badRequest().body(visit);
        }
        visit.setStatus(VisitStatus.APPROVED);
        return ResponseEntity.ok(visitRepository.save(visit));
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/reject")
    public ResponseEntity<Visit> rejectVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        Visit visit = visitRepository.findById(visitId);
        if (visit.getVetId() != vetId) {
            return ResponseEntity.badRequest().body(visit);
        }
        visit.setStatus(VisitStatus.REJECTED);
        return ResponseEntity.ok(visitRepository.save(visit));
    }

}
