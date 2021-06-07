package interfaces;

import java.util.Queue;
import java.util.Set;

import comunicacion_ingreso.Cliente;

public interface IResincronizacion {

	boolean isPrimary();

	void setPrimary();

	void setSecondary();

	void sincronizar(Cliente lastCalledClient, Set<String> boxes, Queue<Cliente> clientes);
}
