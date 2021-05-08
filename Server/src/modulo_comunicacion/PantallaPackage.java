package modulo_comunicacion;

public class PantallaPackage {
	String DNI;
	String Box;

	public PantallaPackage(String dNI, String box) {
		super();
		DNI = dNI;
		Box = box;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getBox() {
		return Box;
	}

	public void setBox(String box) {
		Box = box;
	}

}
