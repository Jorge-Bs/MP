package uo.mp.lab04.socialnetwork.model;

import uo.mp.lab.util.check.ArgumentChecks;

public class TextMessage extends Post{
	
	private String content;
	
	/**
	 * Constructor que recibe el usuarion y el contenido del texto
	 * @param user de tipo String
	 * @param content de tipo String
	 */
	public TextMessage(String user,String content) {
		super(user);
		setContent(content);
	}

	
	/**
	 * Establece el contenido del post
	 * @param content de tipo Sting
	 */
	private void setContent(String content) {
		ArgumentChecks.isTrue(content!=null & !content.isBlank(), "Contenido invalido");
		this.content = content;
	}
	
	/**
	 * Devuelve el contenido del post
	 * @return content
	 */
	private String getContent() {
		return content;
	}


	/**
	 * devuelve la informacion de la imagen
	 * @return String con la informacion
	 */
	@Override
	public String toString() {
		return String.format("Text message posted by: %s, Content: %s",getUser(),getContent());
	}
	
	
	/**
	 * Devuelve en fomato html el texto
	 * @return html con el formato html del texto
	 */
	public String toHtmlFormat() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("<p> %s </p>",getContent()));
		return sb.toString();
	}
	
}
