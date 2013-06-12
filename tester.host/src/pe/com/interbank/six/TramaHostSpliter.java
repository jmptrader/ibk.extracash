package pe.com.interbank.six;

import org.apache.log4j.Logger;

public class TramaHostSpliter {

	static Logger logger = Logger.getLogger(TramaHostSpliter.class);

	private String excaCIdeProd;
	private String excaCRc;
	private String excaCDesRc;
	private String excaCIndFunc;
	private String excaCNumText;
	private String excaCCodCana;
	private String excaCCodUsua;
	private String excaCCodAgen;

	private String excaONumTcct;
	private String excaONumTdep;
	private String excaONumTdes;
	private String excaOTipCamb;
	private String excaOImpDequ;
	private String excaONumTdeb;
	private String excaONumTcex;
	private String excaOImpDese;
	private String excaOTotCuot;

	public void splitTold91(String string) {
		logger.info("====================>[START SPLIT TOLD91]");

		logger.info("TRAMA TOLD91 ------->[" + string.substring(0, 150) + "]");

		logger.info("CTRANS-DESP -------->[" + string.substring(0, 4) + "]");
		logger.info("CTRANSID ----------->[" + string.substring(4, 12) + "]");
		logger.info("CLOG-TERM ---------->[" + string.substring(12, 19) + "]");
		logger.info("FTERM -------------->[" + string.substring(19, 27) + "]");
		logger.info("HTERM -------------->[" + string.substring(27, 33) + "]");
		logger.info("CRED --------------->[" + string.substring(33, 35) + "]");
		logger.info("COFICINA ----------->[" + string.substring(35, 39) + "]");
		logger.info("CUSERID ------------>[" + string.substring(39, 47) + "]");
		logger.info("CSUPERVID ---------->[" + string.substring(47, 55) + "]");
		logger.info("GSECONDT ----------->[" + string.substring(55, 56) + "]");
		logger.info("GAUTORIZ ----------->[" + string.substring(56, 57) + "]");
		logger.info("CLOG-EXT ----------->[" + string.substring(57, 64) + "]");
		logger.info("CLOG-TERM-EXT ------>[" + string.substring(64, 71) + "]");
		logger.info("GEXT --------------->[" + string.substring(71, 72) + "]");
		logger.info("GCAS --------------->[" + string.substring(72, 73) + "]");
		logger.info("QSEQ --------------->[" + string.substring(73, 74) + "]");
		logger.info("PROGRAMA ----------->[" + string.substring(74, 82) + "]");
		logger.info("LAYOUT-INP --------->[" + string.substring(82, 90) + "]");
		logger.info("TRAMA-TOLD --------->[" + string.substring(90, 91) + "]");
		logger.info("IND-TXFIRMA -------->[" + string.substring(91, 92) + "]");
		logger.info("FILLER ------------->[" + string.substring(92, 150) + "]");

		logger.info("====================>[FINISH SPLIT TOLD91]");
	}

	public void splitExtraCashOutput(int startIndexExtracash, String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA]");
		trama = trama.substring(startIndexExtracash);
		logger.info("TRAMA RNCCEXCA ----->[" + trama.substring(150) + "]");

		splitExtracashHeader(trama);
		splitExtracashInput(trama);
		splitExtracashDataO(trama);
		splitExtracashCuotas(trama);
		splitExtracashHost1(trama);
		splitExtracashHost2(trama);

		logger.info("===================> [FINISH SPLIT RNCCEXCA]");
	}

	private void splitExtracashHeader(String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA HEADER]");
		excaCIdeProd = trama.substring(150, 152);
		excaCRc = trama.substring(152, 154);
		excaCDesRc = trama.substring(154, 234);
		excaCIndFunc = trama.substring(234, 235);
		excaCNumText = trama.substring(235, 247);
		excaCCodCana = trama.substring(247, 249);
		excaCCodUsua = trama.substring(249, 257);
		excaCCodAgen = trama.substring(257, 260);

		logger.info("EXCA-C-IDE-PROD ---->[" + excaCIdeProd + "]");
		logger.info("EXCA-C-RC ---------->[" + excaCRc + "]");
		logger.info("EXCA-C-DES-RC ------>[" + excaCDesRc + "]");
		logger.info("EXCA-C-IND-FUNC ---->[" + excaCIndFunc + "]");
		logger.info("EXCA-C-NUM-TEXT ---->[" + excaCNumText + "]");
		logger.info("EXCA-C-COD-CANA ---->[" + excaCCodCana + "]");
		logger.info("EXCA-C-COD-USUA ---->[" + excaCCodUsua + "]");
		logger.info("EXCA-C-COD-AGEN ---->[" + excaCCodAgen + "]");
	}

	private void splitExtracashInput(String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA INPUT]");
		logger.info("EXCA-I-NUM-PMC ----->[" + trama.substring(260, 272) + "]");
		logger.info("EXCA-I-FEC-PMC ----->[" + trama.substring(272, 280) + "]");
		logger.info("EXCA-I-HOR-PMC ----->[" + trama.substring(280, 286) + "]");
		logger.info("EXCA-I-COD-TPMC ---->[" + trama.substring(286, 292) + "]");
		logger.info("EXCA-I-NUM-DNI ----->[" + trama.substring(292, 300) + "]");
		logger.info("EXCA-I-TIP-TARJ ---->[" + trama.substring(300, 301) + "]");
		logger.info("EXCA-I-NUM-TARJ ---->[" + trama.substring(301, 321) + "]");
		logger.info("EXCA-I-NUM-CUEN ---->[" + trama.substring(321, 337) + "]");
		logger.info("EXCA-I-COD-BANC ---->[" + trama.substring(337, 340) + "]");
		logger.info("EXCA-I-COD-MONE ---->[" + trama.substring(340, 343) + "]");
		logger.info("EXCA-I-TIP-PROD ---->[" + trama.substring(343, 346) + "]");
		logger.info("EXCA-I-NUM-CUOT ---->[" + trama.substring(346, 348) + "]");
		logger.info("EXCA-I-IMP-CUOT ---->[" + trama.substring(348, 363) + "]");
		logger.info("EXCA-I-IMP-EXTR ---->[" + trama.substring(363, 378) + "]");
		logger.info("EXCA-I-IMP-RETI ---->[" + trama.substring(378, 393) + "]");
		logger.info("EXCA-I-IMP-DEPO ---->[" + trama.substring(393, 408) + "]");
		logger.info("EXCA-I-IND-CNUE ---->[" + trama.substring(408, 409) + "]");
		logger.info("EXCA-I-IND-DEPO ---->[" + trama.substring(409, 410) + "]");
		logger.info("EXCA-I-IND-RETI ---->[" + trama.substring(410, 411) + "]");
		logger.info("EXCA-I-DIS-FILLER ->[" + trama.substring(411, 493) + "]");
	}

	private void splitExtracashDataO(String string) {
		logger.info("====================>[START SPLIT RNCCEXCA DATA-O]");
		excaONumTcct = string.substring(493, 500);
		excaONumTdep = string.substring(500, 507);
		excaONumTdes = string.substring(507, 514);
		excaOTipCamb = string.substring(514, 529);
		excaOImpDequ = string.substring(529, 544);
		excaONumTdeb = string.substring(544, 564);
		excaONumTcex = string.substring(564, 584);
		excaOImpDese = string.substring(584, 599);
		excaOTotCuot = string.substring(599, 601);

		logger.info("EXCA-O-NUM-TCCT ---->[" + excaONumTcct + "]");
		logger.info("EXCA-O-NUM-TDEP ---->[" + excaONumTdep + "]");
		logger.info("EXCA-O-NUM-TDES ---->[" + excaONumTdes + "]");
		logger.info("EXCA-O-TIP-CAMB ---->[" + excaOTipCamb + "]");
		logger.info("EXCA-O-IMP-DEQU ---->[" + excaOImpDequ + "]");
		logger.info("EXCA-O-NUM-TDEB ---->[" + excaONumTdeb + "]");
		logger.info("EXCA-O-NUM-TCEX ---->[" + excaONumTcex + "]");
		logger.info("EXCA-O-IMP-DESE ---->[" + excaOImpDese + "]");
		logger.info("EXCA-O-TOT-CUOT ---->[" + excaOTotCuot + "]");
	}

	private void splitExtracashCuotas(String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA CUOTAS]");
		logger.info("EXCA-O-NUM-CUOT(1) ->[" + trama.substring(601, 603) + "]");
		logger.info("EXCA-O-IMP-CUOT(1) ->[" + trama.substring(603, 618) + "]");
		logger.info("EXCA-O-INT-TOTA(1) ->[" + trama.substring(618, 633) + "]");
		logger.info("EXCA-O-NUM-CUOT(2) ->[" + trama.substring(633, 635) + "]");
		logger.info("EXCA-O-IMP-CUOT(2) ->[" + trama.substring(635, 650) + "]");
		logger.info("EXCA-O-INT-TOTA(2) ->[" + trama.substring(650, 665) + "]");
		logger.info("EXCA-O-NUM-CUOT(3) ->[" + trama.substring(665, 667) + "]");
		logger.info("EXCA-O-IMP-CUOT(3) ->[" + trama.substring(667, 682) + "]");
		logger.info("EXCA-O-INT-TOTA(3) ->[" + trama.substring(682, 697) + "]");
		logger.info("EXCA-O-NUM-CUOT(4) ->[" + trama.substring(697, 699) + "]");
		logger.info("EXCA-O-IMP-CUOT(4) ->[" + trama.substring(699, 714) + "]");
		logger.info("EXCA-O-INT-TOTA(4) ->[" + trama.substring(714, 729) + "]");
		logger.info("EXCA-O-NUM-CUOT(5) ->[" + trama.substring(729, 731) + "]");
		logger.info("EXCA-O-IMP-CUOT(5) ->[" + trama.substring(731, 746) + "]");
		logger.info("EXCA-O-INT-TOTA(5) ->[" + trama.substring(746, 761) + "]");
		logger.info("EXCA-O-NUM-CUOT(6) ->[" + trama.substring(761, 763) + "]");
		logger.info("EXCA-O-IMP-CUOT(6) ->[" + trama.substring(763, 778) + "]");
		logger.info("EXCA-O-INT-TOTA(6) ->[" + trama.substring(778, 793) + "]");
		logger.info("EXCA-O-NUM-CUOT(7) ->[" + trama.substring(793, 795) + "]");
		logger.info("EXCA-O-IMP-CUOT(7) ->[" + trama.substring(795, 810) + "]");
		logger.info("EXCA-O-INT-TOTA(7) ->[" + trama.substring(810, 825) + "]");
		logger.info("EXCA-O-NUM-CUOT(8) ->[" + trama.substring(825, 827) + "]");
		logger.info("EXCA-O-IMP-CUOT(8) ->[" + trama.substring(827, 842) + "]");
		logger.info("EXCA-O-INT-TOTA(8) ->[" + trama.substring(842, 857) + "]");
	}

	private void splitExtracashHost2(String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA HOST-2]");
		logger.info("[" + trama.substring(950, 958) + "]");
		logger.info("[" + trama.substring(958, 966) + "]");
		logger.info("[" + trama.substring(966, 980) + "]");
		logger.info("[" + trama.substring(980, 988) + "]");
	}

	private void splitExtracashHost1(String trama) {
		logger.info("====================>[START SPLIT RNCCEXCA HOST-1]");
		logger.info("[" + trama.substring(857, 872) + "]");
		logger.info("[" + trama.substring(872, 887) + "]");
		logger.info("[" + trama.substring(887, 903) + "]");
		logger.info("[" + trama.substring(903, 919) + "]");
		logger.info("[" + trama.substring(919, 950) + "]");
	}

	public String getExcaCIdeProd() {
		return excaCIdeProd;
	}

	public String getExcaCRc() {
		return excaCRc;
	}

	public String getExcaCDesRc() {
		return excaCDesRc;
	}

	public String getExcaCIndFunc() {
		return excaCIndFunc;
	}

	public String getExcaCNumText() {
		return excaCNumText;
	}

	public String getExcaCCodCana() {
		return excaCCodCana;
	}

	public String getExcaCCodUsua() {
		return excaCCodUsua;
	}

	public String getExcaCCodAgen() {
		return excaCCodAgen;
	}

	public String getExcaONumTcct() {
		return excaONumTcct;
	}

	public String getExcaONumTdep() {
		return excaONumTdep;
	}

	public String getExcaONumTdes() {
		return excaONumTdes;
	}

	public String getExcaOTipCamb() {
		return excaOTipCamb;
	}

	public String getExcaOImpDequ() {
		return excaOImpDequ;
	}

	public String getExcaONumTdeb() {
		return excaONumTdeb;
	}

	public String getExcaONumTcex() {
		return excaONumTcex;
	}

	public String getExcaOImpDese() {
		return excaOImpDese;
	}

	public String getExcaOTotCuot() {
		return excaOTotCuot;
	}

}
