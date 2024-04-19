package rally.services.OnboardingReporter.service;


import rally.services.OnboardingReporter.domain.ClientLog;
import rally.services.OnboardingReporter.dto.ClientLogDTO;

import java.util.List;


public interface ClientLogService {
    List<ClientLogDTO> findAll();
    List<ClientLogDTO> findByProcessId(String processId);

    List<ClientLogDTO> findByDeviceType(String deviceType);
}