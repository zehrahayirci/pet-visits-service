package visits;

import visits.domain.VisitStatus;
import visits.infrastructure.data.VisitEntity;

import java.time.ZonedDateTime;

public class OwnerVisitPost {

    private int petId;
    private ZonedDateTime date;
    private int vetId;

    public OwnerVisitPost() {
    }

    public OwnerVisitPost(int petId, ZonedDateTime date, int vetId) {
        this.petId = petId;
        this.date = date;
        this.vetId = vetId;
    }

    public static VisitEntity toVisit(OwnerVisitPost ownerVisitPost, int ownerId, VisitStatus status) {
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPetId(ownerVisitPost.getPetId());
        visitEntity.setDate(ownerVisitPost.getDate());
        visitEntity.setVetId(ownerVisitPost.getVetId());
        visitEntity.setOwnerId(ownerId);
        visitEntity.setStatus(status);
        return visitEntity;
    }

    public int getPetId() {
        return petId;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public int getVetId() {
        return vetId;
    }

}
