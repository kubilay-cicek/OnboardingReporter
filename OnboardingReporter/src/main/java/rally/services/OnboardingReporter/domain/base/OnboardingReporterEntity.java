package rally.services.OnboardingReporter.domain.base;

import javax.persistence.MappedSuperclass;
import rally.commons.persistence.activerecord.ActiveRecordBaseEntity;
import rally.commons.api.dto.LightApiDTO;

@MappedSuperclass
@SuppressWarnings({ "rawtypes" })
public abstract class OnboardingReporterEntity<T extends OnboardingReporterEntity, D extends LightApiDTO>
		extends ActiveRecordBaseEntity<T, D> {
	public abstract String getFilterName();
}
