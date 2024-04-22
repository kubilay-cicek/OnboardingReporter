package rally.services.OnboardingReporter.repository;

import org.springframework.stereotype.Repository;
import rally.services.OnboardingReporter.domain.ClientLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientLogRepository extends OnboardingReporterRepositoryBase<ClientLog> {
    List<ClientLog> findByProcessId(String processId);

    List<ClientLog> findByDeviceType(String deviceType);
}