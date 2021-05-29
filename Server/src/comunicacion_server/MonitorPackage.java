package comunicacion_server;

public class MonitorPackage {
	String ipServer;
	Boolean serverStatus;

	public MonitorPackage(String ip, Boolean status) {
		super();
		this.ipServer = ip;
		this.serverStatus = status;
	}

	public String getIp() {
		return ipServer;
	}

	public void setIp(String ip) {
		this.ipServer = ip;
	}

	public Boolean getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(Boolean serverStatus) {
		this.serverStatus = serverStatus;
	}


}
