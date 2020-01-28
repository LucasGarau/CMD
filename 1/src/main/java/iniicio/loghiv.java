package iniicio;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loghiv")

public class loghiv {
	
	@Id
	@Column(name = "log_id")
	private int _id;

	@Column(name = "log_texte")
	private String _texte;
	
	@Column(name = "log_data")
	private Date _data;
	public loghiv() {
	}
	
	public loghiv(int id, String texte,Date data) {
		this.setId(id);
		this.set_texte(texte);	
		this.set_data(data);
		
			
	}
	
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_texte() {
		return _texte;
	}

	public void set_texte(String _texte) {
		this._texte = _texte;
	}

	public Date get_data() {
		return _data;
	}

	public void set_data(Date _data) {
		this._data = _data;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}


	
}
