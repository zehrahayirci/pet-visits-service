package visits.infrastructure.data;

import visits.domain.VisitStatus;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity(name = "VISIT_ENTITY")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "pet_id")
    private int petId;

    @Column(name = "visit_date")
    private ZonedDateTime date;

    @Column(name = "vet_id")
    private int vetId;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, name = "status")
    private VisitStatus status;

    public VisitEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

    public static final class Builder {
        private Integer id;
        private int ownerId;
        private int petId;
        private ZonedDateTime date;
        private int vetId;
        private VisitStatus status;

        private Builder() {
        }

        public static Builder aVisitEntity() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withOwnerId(int ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder withPetId(int petId) {
            this.petId = petId;
            return this;
        }

        public Builder withDate(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public Builder withVetId(int vetId) {
            this.vetId = vetId;
            return this;
        }

        public Builder withStatus(VisitStatus status) {
            this.status = status;
            return this;
        }

        public VisitEntity build() {
            VisitEntity visitEntity = new VisitEntity();
            visitEntity.id = this.id;
            visitEntity.ownerId = this.ownerId;
            visitEntity.petId = this.petId;
            visitEntity.date = this.date;
            visitEntity.vetId = this.vetId;
            visitEntity.status = this.status;
            return visitEntity;
        }
    }

}
