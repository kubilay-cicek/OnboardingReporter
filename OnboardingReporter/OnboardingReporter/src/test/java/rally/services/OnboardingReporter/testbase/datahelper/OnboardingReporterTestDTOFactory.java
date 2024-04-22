package rally.services.OnboardingReporter.testbase.datahelper;

import java.security.SecureRandom;
import rally.commons.test.datahelper.Generators;

public class OnboardingReporterTestDTOFactory {
	private final SecureRandom rand;
	private final Generators generators;

	public OnboardingReporterTestDTOFactory(SecureRandom rand, Generators generators) {
		this.rand = rand;
		this.generators = new Generators(rand);
	}
}
