@CompositeTypeRegistration( embeddableClass = Money.class, userType = HibernateMoneyUserType.class )
package rally.services.OnboardingReporter.domain;

import org.hibernate.annotations.CompositeTypeRegistration;
import rally.commons.persistence.domain.types.HibernateMoneyUserType;
import rally.commons.persistence.domain.types.Money;