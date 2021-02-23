package visits.domain;


import java.time.ZonedDateTime;

public class Visit {

    private Integer id;
    private int ownerId;
    private int petId;
    private ZonedDateTime date;
    private int vetId;
    private VisitStatus status;

    public Visit() {
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

        public static Builder aVisit() {
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

        public Visit build() {
            Visit visit = new Visit();
            visit.id = this.id;
            visit.ownerId = this.ownerId;
            visit.petId = this.petId;
            visit.date = this.date;
            visit.vetId = this.vetId;
            visit.status = this.status;
            return visit;
        }
    }

}
