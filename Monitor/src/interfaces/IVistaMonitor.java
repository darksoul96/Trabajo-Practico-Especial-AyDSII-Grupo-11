package interfaces;

public interface IVistaMonitor {

	public void setServerPrimarioOffline();
	
	public void setServerSecundarioOffline();
	
	public void setServerPrimarioOnline(String ipPrimario);
	
	public void setServerSecundarioOnline(String ipSecundario);
	
}
