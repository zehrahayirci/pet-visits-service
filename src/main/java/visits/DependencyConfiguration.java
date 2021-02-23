package visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import visits.application.ListVisitService;
import visits.application.SubmitVisitService;
import visits.infrastructure.data.VisitEntitySpringRepository;

@Configuration
public class DependencyConfiguration {

    @Autowired
    VisitEntitySpringRepository visitEntitySpringRepository;

    @Bean
    public ListVisitService listVisitService(){
        return new ListVisitService(visitEntitySpringRepository);
    }

    @Bean
    public SubmitVisitService submitVisitService(){
        return new SubmitVisitService(visitEntitySpringRepository);
    }
}
