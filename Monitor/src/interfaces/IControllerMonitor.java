package interfaces;

public interface IControllerMonitor {

	public void resetServerPrimario();
	
	public void resetServerSecundario();
	
	public void conexionServerPrimario(String ipPrimario);
	
	public void conexionServerSecundario(String ipSecundario);
}
