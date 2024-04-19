package rally.services.OnboardingReporter.main.war;

import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import rally.services.commons.boot.war.RallyBootServletInitializer;
import rally.services.OnboardingReporter.main.OnboardingReporterServer;

public class OnboardingReporterBootServletInitializer extends RallyBootServletInitializer implements WebApplicationInitializer {
    public OnboardingReporterBootServletInitializer() {
        super(LoggerFactory.getLogger(OnboardingReporterServer.class), OnboardingReporterServer.getBootInfo());
    }
}
