package modulo_comunicacion;

import java.io.Serializable;

public class OrdenResponsePackage implements Serializable {
	Boolean sucess;
	String type;
	String info;

	public OrdenResponsePackage(Boolean sucess, String type, String info) {
		super();
		this.sucess = sucess;
		this.type = type;
		this.info = info;
	}

	public Boolean getSucess() {
		return sucess;
	}

	public void setSucess(Boolean sucess) {
		this.sucess = sucess;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
