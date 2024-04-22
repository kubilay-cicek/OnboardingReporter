package rally.services.OnboardingReporter.service;

import rally.services.OnboardingReporter.dto.ClientLogDTO;
import rally.services.OnboardingReporter.dto.LeadPartHistoricFlowDTO;

import java.util.List;

public interface LeadPartyHistoricFlowService {

    List<LeadPartHistoricFlowDTO> findByProcessId(String processId);

}
