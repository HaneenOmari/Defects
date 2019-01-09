package com.example.Defects.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DefectInstance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Auto;
	private long def_id;
	private long id_log;
	
	public DefectInstance() {
		super();
	}
	
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "app")
      private App app;
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "def")
      private Defect def;
	  @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "file")
      private LogFile file;
      public DefectInstance( long def_id, long id_log, App app, Defect def, LogFile logfile) {
		super();
		this.def_id = def_id;
		this.id_log = id_log;
		this.app = app;
		this.def = def;
		this.file = logfile;
	}

	public DefectInstance( long def_id, long id_log, App app, Defect def) {
		super();
	
		this.def_id = def_id;
		this.id_log = id_log;
		this.app = app;
		this.def = def;
	}

	public DefectInstance(  long def_id, long id_log, App app) {
		super();
		this.def_id = def_id;
		this.id_log = id_log;
		this.app = app;
	}

	//Getter and setter
      public App getOwner() {
        return app;
      }

      public void setOwner(App app) {
        this.app = app;
      }
	public long getId_Auto() {
		return id_Auto;
	}
	public void setId_Auto(long id_Auto) {
		this.id_Auto = id_Auto;
	}
	
	public long getDef_id() {
		return def_id;
	}
	public void setDef_id(long def_id) {
		this.def_id = def_id;
	}
	public long getId_log() {
		return id_log;
	}
	public void setId_log(long id_log) {
		this.id_log = id_log;
	}
	
	
	

}
