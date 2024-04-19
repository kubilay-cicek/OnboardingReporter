package rally.services.OnboardingReporter.api.controller;

import rally.services.OnboardingReporter.dto.ClientLogDTO;
import rally.services.OnboardingReporter.service.ClientLogService;
import rally.services.OnboardingReporter.domain.ClientLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client-log")
public class ClientLogController {
    private final ClientLogService clientLogService;

    public ClientLogController(ClientLogService clientLogService) {
        this.clientLogService = clientLogService;
    }

    @GetMapping("/list")
    public List<ClientLogDTO> getAllClientLogs() {
        return clientLogService.findAll();
    }

    @GetMapping("/processId/{processId}")
    public List<ClientLogDTO> getClientLogsByProcessId(@PathVariable String processId) {
        return clientLogService.findByProcessId(processId);
    }

    @GetMapping("/device/{deviceType}")
    public List<ClientLogDTO> getClietLogsByDeviceType(@PathVariable String deviceType) {
        return clientLogService.findByDeviceType(deviceType);

    }


}