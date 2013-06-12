package pe.com.interbank.six;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class ClienteSIXTest {
	static Logger logger = Logger.getLogger(ClienteSIX.class);

	private ClienteSIX clienteSIX;
	private TramaHostSpliter tramaHostSpliter;
	private int startIndexSplitExtracash = 26;
	private String hostDest = "130.30.27.1";
	private String portDest = "4504";
	private String typeSixDrv = "web";
	private String hostName = "s136va12";
	private String userName = "prueba";
	private String password = "prueba";
	private String procDest = "GWYPMCEX";
	private String prefijoTrama = "RNMC    ";
	private Map<String, String> tramasInputHost;

	@Before
	public void before() {
		clienteSIX = new ClienteSIX(hostDest, portDest, typeSixDrv, hostName,
				userName, password, procDest);
		tramaHostSpliter = new TramaHostSpliter();

		TramaInputHostBuilder tramaInputHostBuilder = new TramaInputHostBuilder(
				"resource\\input.host.simulacion.xml");
		tramasInputHost = tramaInputHostBuilder.getTramasInputHost();
	}

	// @Test
	// public void verificarConsultaPlanDePagos() {
	// for (Entry<String, String> tramaInputHost : tramasInputHost.entrySet()) {
	// clienteSIX.execute(prefijoTrama + tramaInputHost.getValue());
	// }
	// }

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_ASAT_4913370001238000() {
		String key = "SIMULACION-TC-VISA-ASAT-4913370001238000";
		logger.info(key);

		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		tramaHostSpliter.splitExtraCashOutput(startIndexSplitExtracash,
				tramaOutputHost);

		assertNotNull(tramaOutputHost);
		assertEquals(tramaHostSpliter.getExcaCRc(), "00");
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_NSAT_4218130500167619() {
		String key = "SIMULACION-TC-VISA-NSAT-4218130500167619";		
		logger.info(key);
		
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		tramaHostSpliter.splitExtraCashOutput(startIndexSplitExtracash,
				tramaOutputHost);

		assertNotNull(tramaOutputHost);
		assertEquals(tramaHostSpliter.getExcaCRc(), "00");
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_NSAT_4390460500017237() {
		String key = "SIMULACION-TC-VISA-NSAT-4390460500017237";
		logger.info(key);
		
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		tramaHostSpliter.splitExtraCashOutput(startIndexSplitExtracash,
				tramaOutputHost);

		assertNotNull(tramaOutputHost);
		assertEquals(tramaHostSpliter.getExcaCRc(), "00");
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_NSAT_4218130500190637() {
		String key = "SIMULACION-TC-VISA-NSAT-4218130500190637";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_NSAT_4218130500193441() {
		String key = "SIMULACION-TC-VISA-NSAT-4218130500193441";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_VISA_NSAT_4218130500193920() {
		String key = "SIMULACION-TC-VISA-NSAT-4218130500193920";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_MASTERCARD_ASAT_5444027995645005() {
		String key = "SIMULACION-TC-MASTERCARD-ASAT-5444027995645005";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_AMERICAN_EXPRESS_ASAT_377752600000245() {
		String key = "SIMULACION-TC-AMERICAN-EXPRESS-ASAT-377752600000245";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TC_AMERICAN_EXPRESS_ASAT_377752600000583() {
		String key = "SIMULACION-TC-AMERICAN-EXPRESS-ASAT-377752600000583";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

	@Test
	public void verificarConsultaPlanDePagos_TD_VISA_ASAT_4547750011379007() {
		String key = "SIMULACION-TD-VISA-ASAT-4547750011379007";
		logger.info(key);
		String tramaInputHost = tramasInputHost.get(key);
		String tramaOutputHost = clienteSIX.execute(prefijoTrama
				+ tramaInputHost);
		assertNotNull(tramaOutputHost);
	}

}
