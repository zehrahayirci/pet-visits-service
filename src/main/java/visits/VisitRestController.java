package visits;

import visits.application.ListVisitService;
import visits.application.SubmitVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import visits.domain.VisitStatus;
import visits.infrastructure.database.VisitEntity;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class VisitRestController {

    @Autowired
    private ListVisitService listVisitService;

    //New Services added
    @Autowired
    private SubmitVisitService submitVisitService;

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<VisitEntity>> getVisits(
            @PathVariable("ownerId") int ownerId) {
        return ResponseEntity.ok(listVisitService.ListbyOwner(ownerId));
    }

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<VisitEntity> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView) {
        VisitEntity visitEntity = OwnerVisitPost.toVisit(ownerVisitView, ownerId, VisitStatus.PENDING);
        return ResponseEntity.ok(submitVisitService.SaveVisit(visitEntity));
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<VisitEntity> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        VisitEntity visitEntity = listVisitService.ListbyId(visitId);
        if (visitEntity.getVetId() != vetId) {
            return ResponseEntity.badRequest().body(visitEntity);
        }
        visitEntity.setStatus(VisitStatus.APPROVED);
        return ResponseEntity.ok(submitVisitService.SaveVisit(visitEntity));
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/reject")
    public ResponseEntity<VisitEntity> rejectVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        VisitEntity visitEntity = listVisitService.ListbyId(visitId);
        if (visitEntity.getVetId() != vetId) {
            return ResponseEntity.badRequest().body(visitEntity);
        }
        visitEntity.setStatus(VisitStatus.REJECTED);
        return ResponseEntity.ok(submitVisitService.SaveVisit(visitEntity));
    }

}
