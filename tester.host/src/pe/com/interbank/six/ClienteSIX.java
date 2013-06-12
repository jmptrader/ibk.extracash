package pe.com.interbank.six;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.novatronic.components.Connection;
import com.novatronic.components.sixclient.tcp.ClienteSIXConnectionFactory;
import com.novatronic.components.sixclient.tcp.ClienteSIXExeBean;
import com.novatronic.components.sixclient.tcp.exception.ClienteSIXConnectionException;

public class ClienteSIX {
	static Logger logger = Logger.getLogger(ClienteSIX.class);

	private String hostDest = "130.30.27.1";
	private String portDest = "4504";
	private String typeSixDrv = "web";
	private String hostName = "s136va12";
	private String userName = "prueba";
	private String password = "prueba";
	private String procDest = "GWYPMCEX";

	public ClienteSIX(String hostDest, String portDest, String typeSixDrv,
			String hostName, String userName, String password, String procDest) {
		this.hostDest = hostDest;
		this.portDest = portDest;
		this.typeSixDrv = typeSixDrv;
		this.hostName = hostName;
		this.userName = userName;
		this.password = password;
		this.procDest = procDest;

	}

	public String execute(String trama) {
		ClienteSIXConnectionFactory factory = null;

		Properties conf = new Properties();

		conf.setProperty("hostdest", hostDest);
		conf.setProperty("portdest", portDest);
		conf.setProperty("typesixdrv", typeSixDrv);

		conf.setProperty("hostname", hostName);
		conf.setProperty("username", userName);
		conf.setProperty("password", password);

		conf.setProperty("procdest", procDest);
		try {
			factory = ClienteSIXConnectionFactory.createConnectionFactory(conf,
					null);
		} catch (ClienteSIXConnectionException e) {
			e.printStackTrace();
			return "";
		}
		Long id = System.currentTimeMillis();

		Connection cn = null;
		try {
			cn = factory.getConnection(id.toString());
		} catch (ClienteSIXConnectionException e) {
			e.printStackTrace();
			return "";
		}

		ClienteSIXExeBean req = new ClienteSIXExeBean();
		req.setId(id.toString());
		req.setOperation(procDest);

		req.setTrama(trama);

		logger.info("SND[" + trama + "]");
		String response = "";
		try {

			logger.info("RCV["
					+ ((ClienteSIXExeBean) cn.execute(req)).getTrama() + "]");
			response = ((ClienteSIXExeBean) cn.execute(req)).getTrama() + "]";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return response;
	}
}
