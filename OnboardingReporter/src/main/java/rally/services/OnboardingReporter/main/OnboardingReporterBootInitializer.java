package rally.services.OnboardingReporter.main;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rally.services.commons.boot.rally.RallyServiceInitializer;

@Component
public class OnboardingReporterBootInitializer extends RallyServiceInitializer {
	@Override
	protected void onApplicationInit(ContextRefreshedEvent event) {
		// do nothing
	}
}
