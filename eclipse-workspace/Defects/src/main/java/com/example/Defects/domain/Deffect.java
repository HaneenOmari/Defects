package com.example.Defects.domain;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Entity
public class Deffect {

	@Id
	private String Def_id;
	private String severity,error_code;
	private String id_sol;
	
	public Deffect(String def_id, String severity, String error_code, String id_sol) {
		super();
		Def_id = def_id;
		this.severity = severity;
		this.error_code = error_code;
		this.id_sol = id_sol;
	}
	
	public Deffect() {
		
	}

	public String getDef_id() {
		return Def_id;
	}

	public void setDef_id(String def_id) {
		Def_id = def_id;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getId_sol() {
		return id_sol;
	}

	public void setId_sol(String id_sol) {
		this.id_sol = id_sol;
	}


}
