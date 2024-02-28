package uo.mp.lab04.socialnetwork.model;

import java.util.ArrayList;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class Post {
	public static final int DEFAULT_LIKES =0;
	public static final String DEFAULT_COMMENTS= null;
	
	
	private String user;
	private int likes;
	private ArrayList<String> comments = new ArrayList<>();
	
	/**
	 * Constructor que recibe el usuario y establece el el post y coment a un valor default
	 * @param user de tipo String
	 */
	public Post(String user) {
		setUser(user);
		setLikes(DEFAULT_LIKES);
	}
	
	
	/**
	 * Establece el usuario dado como parametro
	 * @param user de tipo string
	 * 
	 */
	private void setUser(String user) {
		ArgumentChecks.isTrue(user!=null && !user.isBlank(),"Usuario incorrecto");
		this.user=user;
	}
	
	/**
	 * Establece los likes dados como parametro
	 * @param likes
	 * 
	 */
	public void setLikes(int likes) {
		ArgumentChecks.isTrue(likes>=0,"Likes no pueden ser negativos");
		this.likes=likes;
	}
	
	/**
	 * Establece los comentarios 
	 * @param comment de tipo String 
	 */
	public void setComment(String comment) {
		ArgumentChecks.isTrue(comment!=null && !comment.isBlank(),"Comentario invalido");
		comments.add(comment);
	}
	
	/**
	 * Devuelve el usuario
	 * @return string user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Devuelve los likes
	 * @return likes de tipo int
	 */
	public int getLikes() {
		return likes;
	}
	
	/**
	 * Devuelve el comentario
	 * @return comment
	 */
	public String getComent() {
		StringBuilder sb = new StringBuilder();
		for(String comment:comments) {
			sb.append(comment);
		}
		return sb.toString();
	}
	
	/**
	 * devuelve la informacion del post
	 * @return String con la informacion
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Devuelve el formato html del post
	 * @return string con el formato html
	 */
	public abstract String toHtmlFormat();
	
}
