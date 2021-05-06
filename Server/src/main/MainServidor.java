package main;

import gestion_turnos.Servidor;
import modulo_comunicacion.Receptor_server;

public class MainServidor {

	public static void main(String[] args) {
		Receptor_server receptor = new Receptor_server();
		Servidor servidor = Servidor.getInstance();
		receptor.recibir();
		System.out.println("SERVIDOR ANDANDO");
	}
}
