package rally.services.OnboardingReporter.testbase;

import rally.commons.api.dto.RelatedEntityDTO;
import rally.services.OnboardingReporter.testbase.datahelper.OnboardingReporterTestDOFactory;
import rally.services.OnboardingReporter.testbase.datahelper.OnboardingReporterTestDTOFactory;
import rally.services.commons.testbase.RallyCommonsBootUnitTestBase;

/**
 *
 * @author IS96844
 *
 */
public abstract class RallyOnboardingReporterUnitTestBase extends RallyCommonsBootUnitTestBase {

    static {
        setupFactories();
    }

    protected static OnboardingReporterTestDTOFactory dtoFactory;

    protected static OnboardingReporterTestDOFactory doFactory;

    private static void setupFactories() {
        dtoFactory = new OnboardingReporterTestDTOFactory(random, generators);
        doFactory = new OnboardingReporterTestDOFactory(random);
    }

    protected RelatedEntityDTO randRelatedEntityDTO() {
        return new RelatedEntityDTO(randLong(), randCode(), randName());
    }
}
