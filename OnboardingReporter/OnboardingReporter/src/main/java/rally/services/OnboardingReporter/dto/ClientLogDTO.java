package rally.services.OnboardingReporter.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ClientLogDTO extends BaseDTO implements Serializable {

    private String page;
    private String text;
    private String stack;
    private String referenceNo;
    private String exceptionCode;
    private String processId;
    private String deviceType;
    private String deviceModel;
    private String deviceId;
    private String osVersion;
    private Boolean hasJailBreak;
}
