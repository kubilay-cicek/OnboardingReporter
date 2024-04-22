package rally.services.OnboardingReporter.domain.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rally.commons.api.dto.BaseApiDTO;
import rally.commons.api.dto.LightApiDTO;
import rally.commons.persistence.activerecord.ActiveRecordBaseEntity;
import rally.commons.persistence.domain.embed.audit.EntityActivityDateTimeStamp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<T extends BaseEntity<T, D>, D extends LightApiDTO>
        extends ActiveRecordBaseEntity<T, D> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_USER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CREATED_USER)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_DATETIME,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CREATE_DATE)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_FROM_COMPUTER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CREATED_FROM_COMPUTER)),})
    private EntityActivityDateTimeStamp createStamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_USER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_MODIFIED_USER)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_DATETIME,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_UPDATE_DATE)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_FROM_COMPUTER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_MODIFIED_FROM_COMPUTER)), })
    private EntityActivityDateTimeStamp modifyStamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_USER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_APPROVED_USER)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_DATETIME,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_APPROVE_DATE)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_FROM_COMPUTER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_APPROVED_FROM_COMPUTER)), })
    private EntityActivityDateTimeStamp approvalStamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_USER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CANCELLED_USER)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_DATETIME,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CANCEL_DATE)),
            @AttributeOverride(name = EntityActivityDateTimeStamp.FIELD_FROM_COMPUTER,
                    column = @Column(name = EntityActivityDateTimeStamp.COLUMN_CANCELLED_FROM_COMPUTER)), })
    private EntityActivityDateTimeStamp cancelStamp;


    public BaseEntity() {

    }

    protected <DO extends BaseApiDTO> void applyDTOStamps(DO dto) {
        if (createStamp != null) {
            createStamp.createStamp(dto);
        }

        if (modifyStamp != null) {
            modifyStamp.updateStamp(dto);
        }

        if (approvalStamp != null) {
            approvalStamp.approveStamp(dto);
        }

        if (cancelStamp != null) {
            cancelStamp.cancelStamp(dto);
        }
    }

    public void applyEntityStamps(BaseApiDTO dto) {
        if (hasId()) {
            withUpdateStampFromContext();
        } else {
            withCreateStampFromContext();
        }

        if (dto != null) {
            if (dto.getApprovedByUserCode() != null) {
                this.approvalStamp = EntityActivityDateTimeStamp.fromContext();
            }

            if (dto.getCancelledByUserCode() != null) {
                this.cancelStamp = EntityActivityDateTimeStamp.fromContext();
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public BaseEntity from(BaseEntity accountBaseEntityIn, BaseApiDTO dto) {
        BaseEntity accountBaseEntity = accountBaseEntityIn;

        accountBaseEntity.setId(dto.getId());
        accountBaseEntity.setVersion(dto.getVersion());

        applyEntityStamps(dto);

        return accountBaseEntity;
    }

    public OffsetDateTime getCreateDate() {
        return (createStamp != null) ? createStamp.getDateTime() : null;
    }

    @Override
    public abstract String getFilterName();

    public BaseApiDTO toCustomDTO(BaseApiDTO dto) {
        dto.setId(getId());
        dto.setFilterName(getFilterName());
        dto.setVersion(getVersion());

        applyDTOStamps(dto);

        return dto;
    }


    public D toDTOWithputStamps(D dto) {
        super.toDTO(dto);
        return dto;
    }


    public T updateStampAfterApprove() {
        this.createStamp = EntityActivityDateTimeStamp.fromContext();
        this.modifyStamp = EntityActivityDateTimeStamp.fromContext();

        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withCreateStampFromContext() {
        this.createStamp = EntityActivityDateTimeStamp.fromContext();
        this.modifyStamp = createStamp.copy();

        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withUpdateStampFromContext() {
        this.modifyStamp = EntityActivityDateTimeStamp.fromContext();

        return (T) this;
    }

    @PreUpdate
    public void setUpdateTimeStamps() {
        Logger logger = LoggerFactory.getLogger(BaseEntity.class);
        try {
            withUpdateStampFromContext();
        } catch (Exception e) {
            try {
                this.modifyStamp =
                        new EntityActivityDateTimeStamp(null, InetAddress.getLocalHost().toString(),
                                OffsetDateTime.now());
            } catch (UnknownHostException unknownHostException) {
                logger.error("UnknownHostException : ", e);
            }
        }
    }

    @PrePersist
    public void setInsertTimeStamps() {
        Logger logger = LoggerFactory.getLogger(BaseEntity.class);
        try {
            withCreateStampFromContext();
        } catch (Exception e) {
            try {
                this.createStamp =
                        new EntityActivityDateTimeStamp(null, InetAddress.getLocalHost().toString(),
                                OffsetDateTime.now());
            } catch (UnknownHostException unknownHostException) {
                logger.error("UnknownHostException : ", e);
            }

        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
