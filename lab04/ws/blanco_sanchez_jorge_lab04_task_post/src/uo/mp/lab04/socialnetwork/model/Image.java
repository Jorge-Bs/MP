package uo.mp.lab04.socialnetwork.model;

import uo.mp.lab.util.check.ArgumentChecks;

public class Image extends Post{
	
	private String file;
	private String caption;
	
	/**
	 * Constructor recibe el usuario y la imagen a subir con su descripcion
	 * @param user
	 */
	public Image(String user,String file,String caption) {
		super(user);
		setFile(file);
		setCaption(caption);
	}
	
	/**
	 * Establece el archivo
	 * @param string file
	 */
	private void setFile(String file) {
		ArgumentChecks.isTrue(file!=null && !file.isBlank(),"Archivo incorrecto");
		this.file=file;
	}
	
	/**
	 * Establece el caption de la imagen
	 * @param caption de la imagen
	 */
	private void setCaption(String caption) {
		ArgumentChecks.isTrue(file!=null && !file.isBlank(),"Archivo incorrecto");
		this.caption=caption;
	}
	
	/**
	 * Obtiene el archivo
	 * @return file
	 */
	private String getFile() {
		return file;
	}
	
	/**
	 * Obtiene el caption
	 * @return caption
	 */
	private String getCaption() {
		return caption;
	}
	
	
	/**
	 * Obtiene la cadena correspondiente a la informacion
	 * @return string con la informacion de la imagen
	 */
	public String toString() {
		return String.format("Photo posted by: %s, File: %s, Caption: %s",getUser(),getFile(),getCaption());
	}
	
	/**
	 * Devuelve en formato html
	 */
	public String toHtmlFormat() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("<img src= %s> %s </img>",getFile(),getCaption()));
		return sb.toString();
	}
	
	
}
