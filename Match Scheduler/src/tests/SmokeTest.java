package tests;

import java.io.PrintWriter;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class SmokeTest {
	SummaryGeneratingListener listener = new SummaryGeneratingListener();

	public static void main(String[] args) {
		SmokeTest runner = new SmokeTest();
		runner.runAll();

		TestExecutionSummary summary = runner.listener.getSummary();
		summary.printTo(new PrintWriter(System.out));
	}

	public void runAll() {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request().selectors(selectPackage("tests")).filters(includeClassNamePatterns(".*Test")).build();
		Launcher launcher = LauncherFactory.create();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}
}
