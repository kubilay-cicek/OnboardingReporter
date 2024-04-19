package rally.services.OnboardingReporter.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.NoRepositoryBean;
import rally.commons.persistence.activerecord.ActiveRecordBaseEntity;
import rally.commons.persistence.activerecord.ActiveRecordRepository;

@SuppressWarnings("rawtypes")
@Transactional
@NoRepositoryBean
public interface OnboardingReporterRepositoryBase<T extends ActiveRecordBaseEntity> extends ActiveRecordRepository<T> {
}
