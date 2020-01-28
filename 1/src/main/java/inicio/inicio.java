package inicio;
import java.util.Arrays;    
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import iniicio.idioma;
import iniicio.literal;
import iniicio.loghiv;

import org.hibernate.Session;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hibernate.query.Query;
import org.hibernate.Session;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class inicio {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, SQLException  {
		String idiomaQuery;
		Logger log = Logger.getLogger("org.hibernate");
	    log.setLevel(Level.WARNING); 
		idiomaQuery = "es";
		Session _session = HibernateUtil.getSessionFactory().openSession();	
		
		Scanner sc = new Scanner(System.in);
		String entradaTexte = "";
		File directoriAnterior = new File("");
		int n=0;
		Boolean log_activation=true;
		File directoriActual = new File("");
		TractarEntrada.TipusEntrada darreraEntrada = null;
		File auxDirectori;
		TractarEntrada tractarTexteEntrada;
		
		while (darreraEntrada != TractarEntrada.TipusEntrada.EXIT) {
			System.out.print(directoriActual.getAbsolutePath() + ">");
			entradaTexte = sc.nextLine();
			tractarTexteEntrada = new TractarEntrada(entradaTexte);
			switch (tractarTexteEntrada.obtenirTipusEntrada()) {
			case GOTO:
				 
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
			
				 if (directoriActual.getPath()=="" ) {
				 auxDirectori = new
						 
				File(tractarTexteEntrada.obtenirParametres()[0]);

				 }else {
				 auxDirectori = new File(directoriActual.getPath() +

				directoriActual.separator +
				tractarTexteEntrada.obtenirParametres()[0]);

				 }
				
				 if (auxDirectori.exists() && auxDirectori.isDirectory()) {
				 directoriAnterior = directoriActual;
				 directoriActual = auxDirectori;
				 } else {
					

					    selectmaven(_session,idiomaQuery,"directorinotrobat");
					     
				 }
				break;
			case GOLAST:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				if (directoriAnterior.getAbsolutePath() !="") {
					directoriActual=directoriAnterior;
				}
				
				else {
					 selectmaven(_session,idiomaQuery,"directorinotrobat");
				     
				}
				
				break;
			case LIST:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				String[] llistatElements = directoriActual.getAbsoluteFile().list();
				if (llistatElements != null && llistatElements.length > 0) {
					for (int i = 0; i < llistatElements.length; i++) {
						System.out.println(llistatElements[i]);
					}
				} else {
				
					     selectmaven(_session,idiomaQuery,"dirsenseelements");
					     
					
				}
				break;
			case UP:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				if (directoriActual.getAbsoluteFile().getParentFile() != null) {
					directoriActual=directoriActual.getAbsoluteFile().getParentFile();
				} else {
					 
					     selectmaven(_session,idiomaQuery,"directoriparenotrobat");
					
				}
				break;
			case INFOFILE:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				
				String url=(directoriActual.getPath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				System.out.println(url);
				auxDirectori=new File(directoriActual.getPath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				if (auxDirectori.isFile()==true) {
					System.out.println(auxDirectori);
					System.out.println(auxDirectori.getName());
					System.out.println(auxDirectori.getAbsolutePath());
					System.out.println(auxDirectori.length());
					System.out.println(auxDirectori.lastModified());
					System.out.println(auxDirectori.canExecute());
					System.out.println(auxDirectori.canRead());
					System.out.println(auxDirectori.canWrite());
					System.out.println(auxDirectori.canWrite());
					String lastFourDigits = url.substring(url.length() - 3);
					System.out.println(lastFourDigits);
					
				}else {
					
					     selectmaven(_session,idiomaQuery,"Fitxer");
					
				}
				
				
				break;
			case INFODIR:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				if (auxDirectori.isDirectory()==true) {
					System.out.println(auxDirectori);
					System.out.println(auxDirectori.getName());
					System.out.println(auxDirectori.canRead());
					System.out.println(auxDirectori.length());
					System.out.println(auxDirectori.canExecute());
					System.out.println(auxDirectori.canRead());
					System.out.println(auxDirectori.canWrite());
					
					
					
				}else {
					 selectmaven(_session,idiomaQuery,"Fitxer");
					     
				}
				break;
			case HELP:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				System.out.println("Els comandos disponibles son:");
				System.out.println("GOTO:");
				System.out.println("GOLAST:");
				System.out.println("LIST:");
				System.out.println("UP:");
				System.out.println("INFOFILE:");
				System.out.println("INFODIR:");
				System.out.println("HELP:");
				System.out.println("CREATEDIR:");
				System.out.println("CREATEFILE:");
				System.out.println("SORTBY:");
				System.out.println("DELETEDIR:");
				System.out.println("DELETEFILE:");
				System.out.println("EXIT:");
				break;
			case CREATEDIR:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				
				n=tractarTexteEntrada.obtenirlenght();
				if (directoriActual.exists()) {
					for (int i = 0; i < n ; i++) {
						auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[i]);
						auxDirectori.mkdir();
						
						     selectmaven(_session,idiomaQuery,"creatcorrectament");
				} 
					
				}else {
						
					     selectmaven(_session,idiomaQuery,"directorinotrobat");
				}
				
				
				
				break;
			case CREATEFILE:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				if (directoriActual.exists()) {
				n=tractarTexteEntrada.obtenirlenght();
				System.out.println(n);
				
				for (int i = 0; i < n ; i++) {
					auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[i]);
					auxDirectori.createNewFile();
					  selectmaven(_session,idiomaQuery,"directorinotrobat");
				}
				}else {
					
					    selectmaven(_session,idiomaQuery,"directorinotrobat");
				}
			
				break;
			case SORTBY:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				
					File[] stuff = directoriActual.listFiles();	
					String crit = tractarTexteEntrada.obtenirParametres()[0].toLowerCase();
					switch(crit){
						case "name":
							try {
								Files.list(Paths.get(directoriActual.getPath())).sorted().forEach(System.out::println);
							} catch (IOException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "date":
							File[] files = directoriActual.listFiles();
							File curr;
							BasicFileAttributes attr;
							Arrays.sort(files, Comparator.comparingLong(File::lastModified));
							try {
								for (short i=0; i<files.length; ++i) {
									curr=files[i];
									attr= Files.readAttributes(Paths.get(curr.getPath()), BasicFileAttributes.class);
									System.out.println(curr.getName()+" LastModified: "+attr.lastModifiedTime());
								}
							}catch(IOException e) {
								System.out.println(e.getMessage());
							}
							break;
						default:	
							System.out.println("Sorting criteria not recognized");
							for (short i=0; i<stuff.length; ++i) {
								System.out.println(stuff[i].getName());
							}
							break;
					}
				
				
			case DELETEDIR:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				if (auxDirectori.isDirectory()==true) {
				auxDirectori.delete();
				System.out.println("Directorio borrado");
				}else {
					
				     selectmaven(_session,idiomaQuery,"Directori");
				}
				break;
			case DELETEFILE:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				if (auxDirectori.isFile()==true) {
				auxDirectori.delete();
				System.out.println("Archivo borrado");
				}else {
				
				     selectmaven(_session,idiomaQuery,"Fitxer");
				}
				break;
				
				
				//sale de el programa
			case EXIT:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
			
				selectmaven(_session,idiomaQuery,"fiexecucio");
				System.out.println("Adios que tenga un buen dia.");
				_session.close();
				darreraEntrada = TractarEntrada.TipusEntrada.EXIT;
				break;
			case ERROR:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				break;
				//Cambia el booleano para activar o desactivar el log
			case LOG:
			if (log_activation=true) {
					maveninsert(_session,entradaTexte);
			}
			if (tractarTexteEntrada.obtenirParametres()[0]=="1") {
				log_activation=true;
				
				     selectmaven(_session,idiomaQuery,"logactivat");
				
			}else if (tractarTexteEntrada.obtenirParametres()[0]=="0") {
				log_activation=false;
				selectmaven(_session,idiomaQuery,"logdesactivat");
				     
			}else {
				System.out.println("Comanda no valida");
				}
				break;
				
				//Borra el log
			case CLEARLOG:
				clear(_session);
				break;
				//Carga ficheros
			case LOAD:
				if (log_activation=true) {
					maveninsert(_session,entradaTexte);
				}
				auxDirectori=new File(directoriActual.getAbsolutePath()+directoriActual.separator + tractarTexteEntrada.obtenirParametres()[0]);
				readFileReader(auxDirectori);
				break;
			}
		}
	}
	//Se encarga de escribir en el log de la base de dades.
	public static void maveninsert(Session _session, String filecontent) throws IOException {
		loghiv log = new loghiv();
    	log.set_texte(filecontent);
    	log.set_data(new Date());
    	_session.beginTransaction();
    	_session.save(log);
    	_session.getTransaction().commit();
    	_session.clear();
	}
	
	//Borra tot lo que hay en el log
	public static void clear(Session _session) throws IOException {
		_session.beginTransaction();
		_session.createSQLQuery("TRUNCATE TABLE LOGHIV").executeUpdate();
		_session.getTransaction().commit();
	
	}
	
	
	
	//Fa un select de el codigo de error que vulguis executar.
	public static void selectmaven(Session _session,String idiomaQuery,String litcodigo) {
		try {
			List<literal> result2 = (List<literal>)_session.createQuery("from literal where lit_clau = '"+litcodigo+"' and idi_cod = '" + idiomaQuery + "'").list();
			System.out.println(result2.get(0).get_text());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//Llegeix el fitxers y els intenta executar.
		public static String readFileReader(File f )throws IOException {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			String readedcontent = "";
			while (str != null) {
				readedcontent += str + "\r\n";
				str = br.readLine();
			}
			br.close();
			fr.close();
			return readedcontent;
		}
	
		
		
	}

