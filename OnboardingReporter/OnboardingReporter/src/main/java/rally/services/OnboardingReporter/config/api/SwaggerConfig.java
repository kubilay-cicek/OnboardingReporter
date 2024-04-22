package rally.services.OnboardingReporter.config.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rally.commons.api.config.BaseSwaggerConfiguration;
import rally.commons.api.config.SwaggerConfigurer;
import org.springdoc.core.models.GroupedOpenApi;
import rally.services.OnboardingReporter.main.OnboardingReporterServer;

@Configuration
public class SwaggerConfig extends BaseSwaggerConfiguration {
	public SwaggerConfig() {
		super(OnboardingReporterServer.getVersionInfo());
	}

	@Bean
	public GroupedOpenApi apiDoc() {
		return new SwaggerConfigurer("OnboardingReporter-api", "OnboardingReporterApi", "Rally OnboardingReporter Api", "/api/**",
				versionInfo.getProjectVersion(), getGlobalMandatoryHeaders()).build();
	}
}
