package interfaces;

import java.util.ArrayList;
import java.util.Set;

import comunicacion_ingreso.Cliente;

public interface IResincronizacion {

	boolean isPrimary();

	void setPrimary();

	void setSecondary();

	void sincronizar(Cliente lastCalledClient, Set<String> boxes, ArrayList<Cliente> clientes);
}
