package visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import visits.application.ListVisitService;
import visits.application.SubmitVisitService;

@Configuration
public class DependencyConfiguration {

    @Autowired
    VisitRepository visitRepository;

    @Bean
    public ListVisitService listVisitService(){
        return new ListVisitService(visitRepository);
    }

    @Bean
    public SubmitVisitService submitVisitService(){
        return new SubmitVisitService(visitRepository);
    }
}
