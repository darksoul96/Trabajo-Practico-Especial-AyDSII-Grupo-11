package interfaces;

import paquetes.MonitorPackage;

public interface IHeartBeat {

	public void resetServerPrimario();

	public void resetServerSecundario();

	public void conexionServerPrimario(MonitorPackage paquete);

	public void conexionServerSecundario(MonitorPackage paquete);

}
