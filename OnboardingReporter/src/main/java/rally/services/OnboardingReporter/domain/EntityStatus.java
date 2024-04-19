package rally.services.OnboardingReporter.domain;


import lombok.Getter;

@Getter
public enum EntityStatus {
    ACTIVE(true,0), // 0
    PENDING(false,1), // 1
    PASSIVE(false,2), // 2
    CANCELLED(false,3), // 3
    READY(false,4), // 4
    BLOCKED(false,5), // 5
    DELETED(true,6), // 6
    ENTITY_ANONYMIZED (true,7); // 7
    private final Boolean visible;
    private final Integer id;

    EntityStatus(Boolean visible, Integer id) {
        this.visible = visible;
        this.id = id;
    }
}
