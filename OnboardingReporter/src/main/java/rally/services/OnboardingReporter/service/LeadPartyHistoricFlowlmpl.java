package rally.services.OnboardingReporter.service;

import org.springframework.stereotype.Service;
import rally.services.OnboardingReporter.domain.base.LeadPartyHistoricFlow;
import rally.services.OnboardingReporter.dto.LeadPartHistoricFlowDTO;
import rally.services.OnboardingReporter.repository.LeadPartyHistoricFlowRepository;

import java.util.List;

@Service
public class LeadPartyHistoricFlowlmpl implements LeadPartyHistoricFlowService{

    public LeadPartyHistoricFlowlmpl(LeadPartyHistoricFlowRepository leadPartyHistoricFlowRepository) {
        this.leadPartyHistoricRepository = leadPartyHistoricFlowRepository;

    }

    private final LeadPartyHistoricFlowRepository  leadPartyHistoricRepository;

    @Override
    public List<LeadPartHistoricFlowDTO> findByProcessId(String processId) {
        return LeadPartyHistoricFlow.convertToDTOList(leadPartyHistoricRepository.findByProcessId(processId));
    }

}
