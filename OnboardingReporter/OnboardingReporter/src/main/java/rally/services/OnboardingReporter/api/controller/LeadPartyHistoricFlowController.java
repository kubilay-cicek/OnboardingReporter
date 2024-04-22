package rally.services.OnboardingReporter.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rally.services.OnboardingReporter.dto.ClientLogDTO;
import rally.services.OnboardingReporter.dto.LeadPartHistoricFlowDTO;
import rally.services.OnboardingReporter.service.LeadPartyHistoricFlowService;

import java.util.List;


@RestController
@RequestMapping("/api/lead-party-historic-flow")
public class LeadPartyHistoricFlowController {

    private final LeadPartyHistoricFlowService leadPartyHistoricFlowService;

    public LeadPartyHistoricFlowController(LeadPartyHistoricFlowService leadPartyHistoricFlowService) {
        this.leadPartyHistoricFlowService = leadPartyHistoricFlowService;
    }

    @GetMapping("/processId/{processId}")
    public List<LeadPartHistoricFlowDTO> getLeadPartyHistoricFlowsByProcessId(@PathVariable String processId) {
        return leadPartyHistoricFlowService.findByProcessId(processId);

    }
}
