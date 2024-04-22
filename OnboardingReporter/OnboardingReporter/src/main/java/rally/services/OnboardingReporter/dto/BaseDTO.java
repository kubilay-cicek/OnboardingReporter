package rally.services.OnboardingReporter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rally.commons.api.dto.LightApiDTO;
import rally.commons.persistence.domain.embed.audit.EntityActivityDateTimeStamp;
import rally.services.OnboardingReporter.domain.EntityStatus;

@Getter
@Setter
public class BaseDTO extends LightApiDTO {

    @JsonIgnore
    private EntityActivityDateTimeStamp createStamp;

    @JsonIgnore private EntityActivityDateTimeStamp modifyStamp;

    @JsonIgnore private EntityActivityDateTimeStamp approvalStamp;

    @JsonIgnore private EntityActivityDateTimeStamp cancelStamp;

    private EntityStatus status;

    @JsonIgnore private Integer version;

    private Long assigneeId;
}
