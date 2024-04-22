package rally.services.OnboardingReporter.api.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import rally.commons.api.handler.BaseRestPersistenceErrorHandler;

@RestControllerAdvice(annotations = RestController.class)
public class RestErrorHandler extends BaseRestPersistenceErrorHandler {
}
