package rally.services.OnboardingReporter.main;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rally.commons.version.VersionProvider;
import rally.services.OnboardingReporter.config.OnboardingReporterConfig;
import rally.services.OnboardingReporter.config.api.SwaggerConfig;
import rally.services.commons.boot.main.BootRunner;
import rally.services.commons.boot.main.Bootable;
import rally.services.commons.boot.main.BootableServer;
import rally.services.commons.boot.main.RallyService;

@Configuration
@Import({ OnboardingReporterConfig.class, SwaggerConfig.class })
public class OnboardingReporterServer extends RallyService {
	public OnboardingReporterServer() {
		this.serverVersion = getVersionInfo();
	}

	public static Bootable getBootInfo() {
		return new BootableServer("OnboardingReporter", "rallyAppHome", OnboardingReporterServer.class, "OnboardingReporter.pid", getVersionInfo());
	}

	private static String getRootPackage() {
        return StringUtils.substringBeforeLast(OnboardingReporterServer.class.getPackage().getName(), ".");
    }

    public static VersionProvider getVersionInfo() {
        return VersionProvider.of(getRootPackage());
    }

	public static void main(String[] args) {
		start(args);
	}

	/**
	 * User by commons daemon for service startup
	 *
	 * @param args
	 */
	public static void start(String[] args) {
		BootRunner.start(getBootInfo(), args);
	}

	/**
	 * User by commons daemon for service shutdown
	 *
	 * @param args
	 */
	public static void stop(String[] args) {
		BootRunner.stop(getBootInfo(), args);
	}
}
