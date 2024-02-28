package uo.mp.lab04.socialnetwork.ui;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.lab04.socialnetwork.model.Image;
import uo.mp.lab04.socialnetwork.model.Post;
import uo.mp.lab04.socialnetwork.model.TextMessage;
import uo.mp.lab04.socialnetwork.service.SocialNetwork;

public class SocialNetworkApp {
	private SocialNetwork snw;
	
	/**
	 * Simula dos clientes, añade post de dos usuario distintos, imprime todos los post e 
	 * imprime los post de cada usuario
	 */
	public void simulateClient() {
		createSocialNetwork();
		addPost();
		printPost();
		printPostPerUser();
		printHtml();
	}
	
	/**
	 * Inicializa la red
	 */
	private void createSocialNetwork() {
		snw= new SocialNetwork();
	}
	/**
	 * Añade post de los usuarios
	 */
	private void addPost() {
		//user 1
		Post post1 = new Image("user1","gatos.jpg","Gatos divertidos");
		Post post2 = new TextMessage("user1","Feliz día");
		//user 2
		Post post3= new Image("user2","paisaje.png","Atardecer en la montaña");
		Post post4 = new TextMessage("user2", "Happy birthday user1");
		//add post
		snw.addPost(post1);
		snw.addPost(post2);
		snw.addPost(post3);
		snw.addPost(post4);
	}
	
	/**
	 * Imprime los post registrados en la plataforma
	 */
	private void printPost() {
		PrintStream out = new PrintStream(System.out);
		snw.listAllPost(out);
	}
	
	/**
	 * Imprime los post de cada usuario
	 */
	private void printPostPerUser() {
		PrintStream out = new PrintStream(System.out);
		ArrayList<Post> postUserOne = snw.findPostByUser("user1");
		out.append("User1 post: \n"+postUserOne.toString()+"\n");
		ArrayList<Post> postUserTwo = snw.findPostByUser("user2");
		out.append("User2 post: \n" +postUserTwo.toString()+"\n");
	}
	
	/**
	 * Imprime el htmnl de los objetos
	 */
	private void printHtml() {
		System.out.print(snw.toHtmlFormat());
	}
}
