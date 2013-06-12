package pe.com.interbank.six;

import org.junit.Before;
import org.junit.Test;

public class TramaHostSpliterTest {

	private TramaHostSpliter tramaHostSpliter;
	private int startIndexSplitExtracash;

	@Before
	public void init() {
		tramaHostSpliter = new TramaHostSpliter();
		startIndexSplitExtracash = 26;
	}

	@Test
	public void verificarExtraCashInputSpliter() {
		tramaHostSpliter
				.splitExtraCashOutput(
						startIndexSplitExtracash,
						"00   0000                                                                                        0000000                                                                    2000EC52TARJETA DE DEBITO NO EXISTE, BUSCA COD.UNICO                                    S000000000000ISIB00000199600000000002020130606145400000020        D4547750011379007                    00300100218000000000000000000000000000000000000000000000000000000000000NSS                                                                                  000000000000000000000000000000000000000000000000000                                                  00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ");
	}

}
