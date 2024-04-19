package rally.services.OnboardingReporter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rally.services.commons.boot.config.BootMainConfig;

@Configuration
@ComponentScan(basePackages = { "rally.services.OnboardingReporter" }, excludeFilters = {
		@ComponentScan.Filter(Configuration.class) })
@EntityScan("rally.services.OnboardingReporter.domain")
public class OnboardingReporterConfig extends BootMainConfig {
}
