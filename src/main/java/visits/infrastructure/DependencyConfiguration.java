package visits.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import visits.application.ListVisitService;
import visits.application.SubmitVisitService;
import visits.application.UpdateVisitStatusService;
import visits.domain.VisitRepository;
import visits.infrastructure.data.VisitEntitySpringRepository;
import visits.infrastructure.data.VisitSpringRepository;

@Configuration
public class DependencyConfiguration {

    @Autowired
    VisitSpringRepository visitSpringRepository;

    @Bean
    public VisitRepository visitRepository(){
        return visitSpringRepository;
    }

    @Bean
    public ListVisitService listVisitService(){
        return new ListVisitService(visitSpringRepository);
    }

    @Bean
    public SubmitVisitService submitVisitService(){
        return new SubmitVisitService(visitSpringRepository);
    }

    @Bean
    public UpdateVisitStatusService updateVisitStatusService() {
        return new UpdateVisitStatusService(visitSpringRepository);
    }
}
