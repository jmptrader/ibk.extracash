package pe.com.interbank.six;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class TramaInputHostBuilder {
	static Logger logger = Logger.getLogger(TramaInputHostBuilder.class);

	private Map<String, String> tramasInputHost;

	public TramaInputHostBuilder(String string) {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(string);
			Document document = (Document) builder.build(xmlFile);
			buildInputHost(document);
		} catch (JDOMException e) {
			logger.error("EXCEPTION PARSEANDO XML");
		} catch (IOException e) {
			logger.error("EXCEPTION LEYENDO FILE" + e.getMessage());
		}
	}

	public Map<String, String> getTramasInputHost() {
		return tramasInputHost;
	}

	@SuppressWarnings("unchecked")
	private void buildInputHost(Document document) {
		logger.info("==================> [START INPUT HOST]");

		Element rootNode = document.getRootElement();

		List<Element> told91s = rootNode.getChildren();
		logger.info("# TRANSACCIONES: [" + told91s.size() + "]");

		tramasInputHost = new HashMap<String, String>();

		for (Element told91 : told91s) {
			tramasInputHost.put(told91.getAttributeValue("idOperacion"),
					buildTold91(told91).toString());
		}

		logger.info("==================> [FINISH INPUT HOST]");
	}

	@SuppressWarnings("unchecked")
	private StringBuilder buildTold91(Element told91) {
		logger.info("==================> [START TOLD91]");

		StringBuilder tramaTold91 = new StringBuilder();
		logger.info("TRANSACCION: [" + told91.getAttributeValue("idOperacion")
				+ "]");

		List<Element> told91Fields = told91.getChildren();
		logger.info("# ELEMENTOS TOLD91: " + told91Fields.size());

		for (Element told91Field : told91Fields) {
			String fieldName = told91Field.getAttributeValue("id");
			String fieldValue = told91Field.getValue();

			if (!fieldName.equalsIgnoreCase("ECASH")) {
				logger.info(fieldName + ": [" + fieldValue + "]");
				tramaTold91.append(fieldValue);
			} else {
				tramaTold91.append(buildRnccExca(told91Field));
			}
		}

		logger.info("RESULT TOLD91: [" + tramaTold91.toString() + "]");
		logger.info("==================> [FINISH TOLD91]");
		return tramaTold91;
	}

	@SuppressWarnings("unchecked")
	private StringBuilder buildRnccExca(Element rnccExca) {
		logger.info("==================> [START RNCCEXCA]");
		StringBuilder tramaRnccExca = new StringBuilder();

		List<Element> rnccExcaFields = rnccExca.getChildren();

		for (Element rnccExcaField : rnccExcaFields) {
			String fieldName = rnccExcaField.getAttributeValue("id");
			String fieldValue = rnccExcaField.getValue();

			logger.info(fieldName + ": [" + fieldValue + "]");
			tramaRnccExca.append(fieldValue);
		}

		logger.info("RESULT RNCCEXCA: [" + tramaRnccExca + "]");
		logger.info("==================> [FINISH RNCCEXCA]");
		return tramaRnccExca;
	}
}
