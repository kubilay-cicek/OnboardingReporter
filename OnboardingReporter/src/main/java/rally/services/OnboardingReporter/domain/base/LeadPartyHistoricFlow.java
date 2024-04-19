package rally.services.OnboardingReporter.domain.base;

import com.google.errorprone.annotations.Immutable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rally.services.OnboardingReporter.dto.LeadPartHistoricFlowDTO;
import rally.services.OnboardingReporter.domain.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static rally.services.OnboardingReporter.domain.ClientLog.convertToDto;
@Setter
@Getter
@Entity
@Immutable
public class LeadPartyHistoricFlow extends BaseEntity<LeadPartyHistoricFlow, LeadPartHistoricFlowDTO> {


    private Long id;
    @Column(name = "process_id")
    private String processId;
    @Column(name = "resource_set")
    private long resourceSet;
    private int sequence;
    @Column(name = "next_sequence")
    private int nextSequence;
    @Column(name = "auto_complete")
    private Boolean autoComplete;
    private int type;
    @Column(name = "channel_type")
    private int channelType;
    private long resource;
    @Column(name = "resource_name")
    private String resourceName;
    private String condition;
    private String parameters;




    @Override
    public String getFilterName() {
        return null;
    }

    public static List<LeadPartHistoricFlowDTO> convertToDTOList(List<LeadPartyHistoricFlow> leadPartyHistoricFlowseadPartHistoricFlowList){

        List<LeadPartHistoricFlowDTO> dtoList = new ArrayList<>();
        for (LeadPartyHistoricFlow flow : leadPartyHistoricFlowseadPartHistoricFlowList) {
            dtoList.add(convertToDto(flow));
        }
        return dtoList;

    }

    public static LeadPartHistoricFlowDTO convertToDto(LeadPartyHistoricFlow leadPartyHistoricFlow) {

        LeadPartHistoricFlowDTO leadPartHistoricFlowDTO = new LeadPartHistoricFlowDTO();

        leadPartHistoricFlowDTO.setId(leadPartHistoricFlowDTO.getId());
        leadPartHistoricFlowDTO.setAutoComplete(leadPartHistoricFlowDTO.getAutoComplete());
        leadPartHistoricFlowDTO.setParameters(leadPartHistoricFlowDTO.getParameters());
        leadPartHistoricFlowDTO.setCondition(leadPartHistoricFlowDTO.getCondition());
        leadPartHistoricFlowDTO.setResource(leadPartHistoricFlowDTO.getResource());
        leadPartHistoricFlowDTO.setChannelType(leadPartyHistoricFlow.getChannelType());
        leadPartHistoricFlowDTO.setNextSequence(leadPartyHistoricFlow.getNextSequence());
        leadPartHistoricFlowDTO.setProcessId(leadPartyHistoricFlow.getProcessId());
        leadPartHistoricFlowDTO.setType(leadPartHistoricFlowDTO.getType());
        leadPartHistoricFlowDTO.setResourceName(leadPartyHistoricFlow.getResourceName());





        return leadPartHistoricFlowDTO;
    }


}
