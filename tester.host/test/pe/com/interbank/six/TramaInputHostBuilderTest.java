package pe.com.interbank.six;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TramaInputHostBuilderTest {

	private TramaInputHostBuilder tramaInputHostBuilder;

	@Before
	public void init() {
		tramaInputHostBuilder = new TramaInputHostBuilder(
				"resource\\input.host.simulacion.xml");
	}

	@Test
	public void verificarTramaInputHostBuilder() {
		Map<String, String> tramasInputHost = tramaInputHostBuilder
				.getTramasInputHost();
		assertNotNull(tramasInputHost);
	}
}
