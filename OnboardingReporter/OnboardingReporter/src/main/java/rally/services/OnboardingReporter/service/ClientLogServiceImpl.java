package rally.services.OnboardingReporter.service;

import rally.services.OnboardingReporter.dto.ClientLogDTO;
import rally.services.OnboardingReporter.repository.ClientLogRepository;
import rally.services.OnboardingReporter.domain.ClientLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientLogServiceImpl implements ClientLogService {

    public ClientLogServiceImpl(ClientLogRepository clientLogRepository) {
        this.clientLogRepository = clientLogRepository;
    }

    private final ClientLogRepository clientLogRepository;

    @Override
    public List<ClientLogDTO> findAll() {
        return ClientLog.convertToDTOList(clientLogRepository.findAll());
    }

    @Override
    public List<ClientLogDTO> findByProcessId(String processId) {
        return ClientLog.convertToDTOList(clientLogRepository.findByProcessId(processId));
    }

    @Override
    public List<ClientLogDTO> findByDeviceType(String deviceType) {
        return ClientLog.convertToDTOList(clientLogRepository.findByDeviceType(deviceType));
    }
}
