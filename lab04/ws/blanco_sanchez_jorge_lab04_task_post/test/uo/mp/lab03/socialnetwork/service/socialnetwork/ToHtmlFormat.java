package uo.mp.lab03.socialnetwork.service.socialnetwork;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.socialnetwork.model.Image;
import uo.mp.lab04.socialnetwork.model.Post;
import uo.mp.lab04.socialnetwork.model.TextMessage;
import uo.mp.lab04.socialnetwork.service.SocialNetwork;

public class ToHtmlFormat {

	private SocialNetwork snt;
	private Post post1;
	private Post post2;
	
	
	@BeforeEach
	public void setUp(){
		snt = new SocialNetwork();
		post1 = new Image("user1","gatos.jpg","Gatos divertidos");
		post2 = new TextMessage("user2","Feliz día");
//		snt.addPost(post1);
//		snt.addPost(post2);
	}
	
	/**
	 * Given: social network sin posts
	 * When: se invoca al metodo
	 * Then: no devuelve nada
	 */
	@Test
	public void testHtmlEmptySocilaMedia() {
		assertEquals("Post en formato html\n",snt.toHtmlFormat());
	}
	
	/**
	 * Given: social network con un  posts
	 * When: se invoca al metodo
	 * Then: devueleve su codigo
	 */
	@Test
	public void testHtmlSocilaMediaWithOnePost() {
		snt.addPost(post1);
		assertEquals("Post en formato html\n<img src= gatos.jpg> Gatos divertidos </img>\n",snt.toHtmlFormat());
	}
	
	/**
	 * Given: social network con dos  posts
	 * When: se invoca al metodo
	 * Then: devueleve su codigo
	 */
	@Test
	public void testHtmlSocilaMediaWithTwoPost() {
		snt.addPost(post1);
		snt.addPost(post2);
		assertEquals("Post en formato html\n"
				+ "<img src= gatos.jpg> Gatos divertidos </img>\n"
				+ "<p> Feliz día </p>\n",snt.toHtmlFormat());
	}

}
