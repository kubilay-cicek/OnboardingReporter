package rally.services.OnboardingReporter.testbase.spring;

import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import rally.commons.config.RallySystemProperties;
import rally.commons.util.generators.IdGenerator;
import rally.services.commons.boot.main.BootRunner;
import rally.services.OnboardingReporter.main.OnboardingReporterServer;
import rally.services.OnboardingReporter.testbase.RallyOnboardingReporterUnitTestBase;

/**
 *
 * @author IS96844
 *
 */
@ActiveProfiles("test")
public abstract class RallyOnboardingReporterSpringTestBase extends RallyOnboardingReporterUnitTestBase {
	
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	static {
		BootRunner.init(OnboardingReporterServer.getBootInfo());
		RallySystemProperties.setEnvProp(RallySystemProperties.SysProps.RALLY_PROFILE, "test");
	}

	@Autowired
	protected IdGenerator idGenerator;

	@Autowired
	protected AbstractApplicationContext context;

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
}
