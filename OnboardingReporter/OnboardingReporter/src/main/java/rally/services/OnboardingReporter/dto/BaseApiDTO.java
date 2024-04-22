package rally.services.OnboardingReporter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import rally.commons.api.dto.LightApiDTO;

import java.time.OffsetDateTime;
@Schema
public class BaseApiDTO extends LightApiDTO {

    private OffsetDateTime createDate;

    private String initiatedByUserCode;

    private String initiatedBranchCode;

    private String fromComputer;

    private OffsetDateTime informationDate;

    private String lastModifiedByUserCode;

    private String lastModifiedByBranchCode;

    private String lastModifiedFromComputer;

    private String approvedByUserCode;

    private String approvedByBranchCode;

    private OffsetDateTime approvalDate;

    private String cancelledByUserCode;

    private String cancelledByBranchCode;

    public void copyInto(BaseApiDTO baseDTO) {
        this.createDate = baseDTO.createDate;
        this.approvalDate = baseDTO.approvalDate;
        this.approvedByUserCode = baseDTO.approvedByUserCode;
        this.fromComputer = baseDTO.fromComputer;
        this.lastModifiedByUserCode = baseDTO.lastModifiedByUserCode;
        this.lastModifiedFromComputer = baseDTO.lastModifiedFromComputer;
        this.informationDate = baseDTO.informationDate;
        this.initiatedByUserCode = baseDTO.initiatedByUserCode;
        this.cancelledByUserCode = baseDTO.cancelledByUserCode;
        this.initiatedBranchCode = baseDTO.initiatedBranchCode;
        this.lastModifiedByBranchCode = baseDTO.lastModifiedByBranchCode;
        this.cancelledByBranchCode = baseDTO.cancelledByBranchCode;
        this.approvedByBranchCode = baseDTO.approvedByBranchCode;
        setVersion(baseDTO.getVersion());
        setId(baseDTO.getId());
    }

    public OffsetDateTime getApprovalDate() {
        return approvalDate;
    }

    public String getApprovedByBranchCode() {
        return approvedByBranchCode;
    }

    public String getApprovedByUserCode() {
        return approvedByUserCode;
    }

    public String getCancelledByBranchCode() {
        return cancelledByBranchCode;
    }

    public String getCancelledByUserCode() {
        return cancelledByUserCode;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public String getFromComputer() {
        return fromComputer;
    }

    public OffsetDateTime getInformationDate() {
        return informationDate;
    }

    public String getInitiatedBranchCode() {
        return initiatedBranchCode;
    }

    public String getInitiatedByUserCode() {
        return initiatedByUserCode;
    }

    public String getLastModifiedByBranchCode() {
        return lastModifiedByBranchCode;
    }

    public String getLastModifiedByUserCode() {
        return lastModifiedByUserCode;
    }

    public String getLastModifiedFromComputer() {
        return lastModifiedFromComputer;
    }

    public void setApprovalDate(OffsetDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public void setApprovedByBranchCode(String approvedByBranchCode) {
        this.approvedByBranchCode = approvedByBranchCode;
    }

    public void setApprovedByUserCode(String approvedByUserCode) {
        this.approvedByUserCode = approvedByUserCode;
    }

    public void setCancelledByBranchCode(String cancelledByBranchCode) {
        this.cancelledByBranchCode = cancelledByBranchCode;
    }

    public void setCancelledByUserCode(String cancelledByUserCode) {
        this.cancelledByUserCode = cancelledByUserCode;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public void setFromComputer(String fromComputer) {
        this.fromComputer = fromComputer;
    }

    public void setInformationDate(OffsetDateTime informationDate) {
        this.informationDate = informationDate;
    }

    public void setInitiatedBranchCode(String initiatedBranchCode) {
        this.initiatedBranchCode = initiatedBranchCode;
    }

    public void setInitiatedByUserCode(String initiatedByUserCode) {
        this.initiatedByUserCode = initiatedByUserCode;
    }

    public void setLastModifiedByBranchCode(String lastModifiedByBranchCode) {
        this.lastModifiedByBranchCode = lastModifiedByBranchCode;
    }

    public void setLastModifiedByUserCode(String lastModifiedByUserCode) {
        this.lastModifiedByUserCode = lastModifiedByUserCode;
    }

    public void setLastModifiedFromComputer(String lastModifiedFromComputer) {
        this.lastModifiedFromComputer = lastModifiedFromComputer;
    }
}
