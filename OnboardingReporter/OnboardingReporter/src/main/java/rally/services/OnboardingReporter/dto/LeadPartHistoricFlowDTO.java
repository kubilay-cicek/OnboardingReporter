package rally.services.OnboardingReporter.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class LeadPartHistoricFlowDTO extends BaseDTO implements Serializable {

    private Long id;
    private String processId;
    private long resourceSet;
    private int sequence;
    private int nextSequence;
    private Boolean autoComplete;
    private int type;
    private int channelType;
    private long resource;
    private String resourceName;
    private String condition;
    private String parameters;

}

