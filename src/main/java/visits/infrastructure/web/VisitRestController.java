package visits.infrastructure.web;

import visits.domain.OwnerVisitPost;
import visits.application.ListVisitService;
import visits.application.SubmitVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import visits.application.UpdateVisitStatusService;
import visits.domain.Visit;
import visits.domain.VisitStatus;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class VisitRestController {

    @Autowired
    private ListVisitService listVisitService;

    @Autowired
    private SubmitVisitService submitVisitService;

    @Autowired
    private UpdateVisitStatusService updateVisitStatusService;

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<Visit>> getVisits(
            @PathVariable("ownerId") int ownerId) {
        return ResponseEntity.ok(listVisitService.listbyOwner(ownerId));
    }

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<Visit> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView) {
        Visit visit = OwnerVisitPost.toVisit(ownerVisitView, ownerId, VisitStatus.PENDING);
        return ResponseEntity.ok(submitVisitService.SaveVisit(visit));
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<Visit> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        try {
            Visit visit = updateVisitStatusService.updateStatus(visitId, vetId, VisitStatus.APPROVED);
            return ResponseEntity.ok(visit);
        }catch (IllegalAccessException exception){
            return ResponseEntity.badRequest().body(Visit.Builder.aVisit().build());
        }
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/reject")
    public ResponseEntity<Visit> rejectVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        try {
            Visit visit = updateVisitStatusService.updateStatus(visitId, vetId, VisitStatus.REJECTED);
            return ResponseEntity.ok(visit);
        }catch (IllegalAccessException exception){
            return ResponseEntity.badRequest().body(Visit.Builder.aVisit().build());
        }
    }

}
