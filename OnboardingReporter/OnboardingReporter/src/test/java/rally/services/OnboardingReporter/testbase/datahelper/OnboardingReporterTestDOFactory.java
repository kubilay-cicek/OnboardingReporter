package rally.services.OnboardingReporter.testbase.datahelper;

import java.security.SecureRandom;

import rally.commons.test.datahelper.Generators;

public class OnboardingReporterTestDOFactory {

    private final Generators generators;

    private final SecureRandom rand;

    public OnboardingReporterTestDOFactory(SecureRandom rand) {
        this.rand = rand;
        this.generators = new Generators(rand);
    }
}
