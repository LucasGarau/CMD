package iniicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "literal")

public class literal {
	
	@Id
	@Column(name = "lit_id")
	private int _id;
	@Column(name = "idi_cod")
	private String _idioma;
	@Column(name = "lit_clau")
	private String _clau;
	@Column(name = "lit_text")
	private String _text ;
	
	
	public literal() {
	}
	
	public literal(int id, String idioma,String clau, String text) {
		this.setId(id);
		this.setIdioma(idioma);	
		this.set_clau(clau);
		this.set_text(text);
	}
	
	public int getId() {
		return _id;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_clau() {
		return _clau;
	}

	public void set_clau(String _clau) {
		this._clau = _clau;
	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}

	public void set_idioma(String _idioma) {
		this._idioma = _idioma;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String get_idioma() {
		return this._idioma;
	}

	public void setIdioma(String idioma) {
		this._idioma = idioma;
	}
	
}
