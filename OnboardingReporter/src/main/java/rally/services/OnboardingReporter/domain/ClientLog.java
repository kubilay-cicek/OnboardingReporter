package rally.services.OnboardingReporter.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rally.commons.persistence.activerecord.ActiveRecordBaseEntity;
import rally.services.OnboardingReporter.domain.base.BaseEntity;
import rally.services.OnboardingReporter.dto.ClientLogDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ClientLog extends BaseEntity<ClientLog, ClientLogDTO> {

    private String page;
    @Column(length = 500)
    private String text;
    @Column(length = 5000)
    private String stack;
    private String referenceNo;
    private String exceptionCode;
    private String processId;
    private String deviceType;
    private String deviceModel;
    private String deviceId;
    private String osVersion;
    private Boolean hasJailBreak;


    @Override
    public String getFilterName() {
        return null;
    }

    public static List<ClientLogDTO> convertToDTOList(List<ClientLog> clientLogList) {
        List<ClientLogDTO> dtoList = new ArrayList<>();
        for (ClientLog log : clientLogList) {
            dtoList.add(convertToDto(log));
        }
        return dtoList;
    }

    public static ClientLogDTO convertToDto(ClientLog clientLog) {
        ClientLogDTO clientLogDTO = new ClientLogDTO();
        clientLogDTO.setId(clientLog.getId());
        clientLogDTO.setProcessId(clientLog.getProcessId());
        clientLogDTO.setPage(clientLog.getPage());
        clientLogDTO.setText(clientLog.getText());
        clientLogDTO.setStack(clientLog.getStack());
        clientLogDTO.setDeviceModel(clientLog.getDeviceModel());
        clientLogDTO.setDeviceId(clientLog.getDeviceId());
        clientLogDTO.setDeviceType(clientLog.getDeviceType());
        clientLogDTO.setExceptionCode(clientLog.getExceptionCode());
        clientLogDTO.setReferenceNo(clientLog.getReferenceNo());
        clientLogDTO.setApprovalStamp(clientLog.getApprovalStamp());
        clientLogDTO.setCancelStamp(clientLog.getCancelStamp());
        clientLogDTO.setCreateStamp(clientLog.getCreateStamp());
        clientLogDTO.setVersion(clientLog.getVersion());
        clientLogDTO.setFilterName(clientLog.getFilterName());
        clientLogDTO.setModifyStamp(clientLog.getModifyStamp());
        clientLogDTO.setVersion(clientLog.getVersion());
        clientLogDTO.setOsVersion(clientLog.getOsVersion());
        clientLogDTO.setHasJailBreak((clientLog.getHasJailBreak()));


        return clientLogDTO;
    }


}
