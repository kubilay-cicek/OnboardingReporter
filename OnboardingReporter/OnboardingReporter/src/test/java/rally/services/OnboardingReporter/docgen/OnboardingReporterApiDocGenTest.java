package rally.services.OnboardingReporter.docgen;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import rally.commons.test.TestConstants;
import rally.services.commons.testbase.OpenapiCodeGenHelper;
import rally.services.OnboardingReporter.main.OnboardingReporterServer;
import rally.services.OnboardingReporter.testbase.spring.RallyOnboardingReporterSpringTestBase;

/**
 *
 * @author IS96844
 *
 */
@SpringBootTest(classes = { OnboardingReporterServer.class })
@WebAppConfiguration
@AutoConfigureMockMvc
@IfProfileValue(name = TestConstants.TEST_GROUP_PROPERTY, value = TestConstants.API_CODEGEN_TEST_GROUP_VALUE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class OnboardingReporterApiDocGenTest extends RallyOnboardingReporterSpringTestBase {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        org.junit.Assume.assumeTrue( System.getenv("API_DOC_GEN_TEST") != null );
    }

    @Test
    public void generateApiDoc() throws Exception {
        OpenapiCodeGenHelper.generate(mockMvc, "OnboardingReporter-api");
    }
}
