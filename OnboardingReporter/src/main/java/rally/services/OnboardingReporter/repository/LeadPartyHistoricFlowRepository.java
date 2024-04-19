package rally.services.OnboardingReporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rally.services.OnboardingReporter.domain.ClientLog;
import rally.services.OnboardingReporter.domain.base.LeadPartyHistoricFlow;

import java.util.List;


public interface LeadPartyHistoricFlowRepository extends OnboardingReporterRepositoryBase<LeadPartyHistoricFlow> {

    List<LeadPartyHistoricFlow> findByProcessId(String processId);


}
