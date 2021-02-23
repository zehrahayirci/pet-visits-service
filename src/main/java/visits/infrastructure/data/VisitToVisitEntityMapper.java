package visits.infrastructure.data;

import org.springframework.stereotype.Component;
import visits.domain.Visit;

@Component
public class VisitToVisitEntityMapper {

    public Visit mapToVisit(VisitEntity visitEntity){
        return Visit.Builder.aVisit()
                .withDate(visitEntity.getDate())
                .withId(visitEntity.getId())
                .withOwnerId(visitEntity.getOwnerId())
                .withPetId(visitEntity.getPetId())
                .withStatus(visitEntity.getStatus())
                .withVetId(visitEntity.getVetId())
                .build();
    }

    public VisitEntity mapToVisitEntity(Visit visit){
        return VisitEntity.Builder.aVisitEntity()
                .withDate(visit.getDate())
                .withId(visit.getId())
                .withOwnerId(visit.getOwnerId())
                .withPetId(visit.getPetId())
                .withStatus(visit.getStatus())
                .withVetId(visit.getVetId())
                .build();
    }
}
