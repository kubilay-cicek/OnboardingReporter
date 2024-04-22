package rally.services.OnboardingReporter.testbase.spring;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rally.commons.test.api.ApiTestConfiguration;
import rally.commons.test.api.CommonsApiTests;
import rally.commons.test.api.JsonConverter;

import rally.services.OnboardingReporter.main.OnboardingReporterServer;

/**
 *
 * @author IS96844
 *
 */
@SpringBootTest(classes = { OnboardingReporterServer.class })
@WebAppConfiguration
public abstract class RallyOnboardingReporterControllerTestBase extends RallyOnboardingReporterSpringTestBase implements JsonConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RallyOnboardingReporterControllerTestBase.class);

    private static String rootUrl;

    private static Class<?> controllerClass;

    protected static void apiBaseSetupAll(String rootUrl, Class<?> cntClass) {
        RallyOnboardingReporterControllerTestBase.rootUrl = rootUrl;
        RallyOnboardingReporterControllerTestBase.controllerClass = cntClass;
    }

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    protected Object controller;

    protected CommonsApiTests apiTests;

    @Before
    public void apiBaseSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        this.controller = webAppContext.getBean(controllerClass);
        this.apiTests = CommonsApiTests.build(mockMvc, "", this,
                ApiTestConfiguration.contentJsonAcceptJson().withContentTypeMapping(HttpMethod.GET, MediaType.ALL));
    }

    protected String buildApiPath(String... segments) {
        return expandPathURL("/" + StringUtils.join(segments, '/'));
    }

    protected String expandPathURL(String path) {
        return new UriTemplate(rootUrl + path).expand().toString();
    }

    protected String expandPathURL(String path, Map<String, Object> pathVariables) {
        return new UriTemplate(rootUrl + path).expand(pathVariables).toString();
    }

    @Override
    public <T> T fromJson(Class<T> resultType, String json) {
        try {
            return objectMapper.readValue(json, resultType);
        } catch (IOException e) {
            LOGGER.error("Could not read json of entity", e);
            return null;
        }
    }

    public <T> T fromJson(MvcResult result, Class<T> resultType) {
        try {
            return fromJson(resultType, result.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Could not read json from result", e);
            return null;
        }
    }

    @Override
    public String toJson(Object entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            LOGGER.error("Could not write json of entity", e);
            return null;
        }
    }
}
