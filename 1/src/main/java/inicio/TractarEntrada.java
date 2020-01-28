package inicio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
public class TractarEntrada {
	private String _entrada;
	private String _error;
	private TipusEntrada _tipusEntrada;
	private String[] _parametres;
	String filePath1 = "C:/foo.txt";
	File log = new File(filePath1);
	String charset = "UTF-8";
	String filePath = "C:/foo.txt";
	 BufferedWriter writer = null;
	
	public enum TipusEntrada {
		GOTO, GOLAST, LIST, UP, INFOFILE, INFODIR, HELP, CREATEDIR, CREATEFILE, SORTBY, DELETEDIR, DELETEFILE, EXIT,
		ERROR,LOG,CLEARLOG,LOAD
	}

	public enum tipusOrdenacio {
		NAME, DATE
	}

	public TractarEntrada(String entrada) {
		this._entrada = entrada;
		carregarObjecte();
	}

	private void carregarObjecte() {
		String auxTexte = this._entrada;
		if (auxTexte != null && !auxTexte.isEmpty()) {
			String[] elements = auxTexte.split(" ");
			switch (elements[0].toLowerCase()) {
			case "goto":
				if (elements.length == 2) {
					this._parametres = new String[1];
					this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.GOTO;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "golast":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.GOLAST;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "list":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.LIST;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "up":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.UP;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
				
			case "infofile":
				if (elements.length == 2) {
				this._parametres = new String[1];
				this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.INFOFILE;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "infodir":
				if (elements.length == 2) {
				this._parametres = new String[1];
				this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.INFODIR;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
				
			case "createdir":
				if (elements.length >= 2) {
				this._parametres = new String[elements.length-1];
				for (int i = 0; i < _parametres.length ; i++) {
				this._parametres[i] = elements[i+1];
				}
					this._tipusEntrada = TipusEntrada.CREATEDIR;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "createfile":
				if (elements.length >= 2) {
					this._parametres = new String[elements.length-1];
					for (int i = 0; i < _parametres.length ; i++) {
					this._parametres[i] = elements[i+1];
					}
						this._tipusEntrada = TipusEntrada.CREATEFILE;
					} else {
						this._tipusEntrada = TipusEntrada.ERROR;
						this._error = "Nombre de parametres incorrecte";
					}
				break;
			case "deletedir":
				if (elements.length >=2) {
				this._parametres = new String[1];
				this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.DELETEDIR;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "deletefile":
				if (elements.length == 2) {
				this._parametres = new String[1];
				this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.DELETEFILE;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "exit":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.EXIT;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "sortby":
				if (elements.length == 2) {
					this._parametres = new String[1];
					this._parametres[0] = elements[1];
					this._tipusEntrada = TipusEntrada.SORTBY;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "help":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.HELP;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "log":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.LOG;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "clearlog":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.CLEARLOG;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			case "load":
				if (elements.length == 1) {
					this._tipusEntrada = TipusEntrada.LOAD;
				} else {
					this._tipusEntrada = TipusEntrada.ERROR;
					this._error = "Nombre de parametres incorrecte";
				}
				break;
			default:
				
				this._tipusEntrada = TipusEntrada.ERROR;
				break;
				
			}
			
			
		} else {
			this._tipusEntrada = TipusEntrada.ERROR;
			this._error = "Sense texte";
		}
	}

	public TipusEntrada obtenirTipusEntrada() {
		return this._tipusEntrada;
	}

	public String[] obtenirParametres() {
		return this._parametres;
	}
	public int obtenirlenght() {
		return this._parametres.length;
	}

	public String obtenirError() {
		return this._error;
	}


}