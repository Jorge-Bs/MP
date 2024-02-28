package uo.mp.lab03.socialnetwork.service.socialnetwork;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.socialnetwork.model.Image;
import uo.mp.lab04.socialnetwork.model.Post;
import uo.mp.lab04.socialnetwork.model.TextMessage;
import uo.mp.lab04.socialnetwork.service.SocialNetwork;

public class AddPostTest {
	private SocialNetwork snt,snt2;
	private Post post1;
	private Post post2;
	
	@BeforeEach
	public void setUp(){
		snt = new SocialNetwork();
		snt2 = new SocialNetwork();
		post1 = new Image("user1","gatos.jpg","Gatos divertidos");
		post2 = new TextMessage("user2","Feliz día");
		snt2.addPost(post1);
		
	}

	/**
	 * Given: SocialNetwork sin ningun post
	 * When: Se invoca al metodo
	 * Then: se añaden dos elemtos a la coleccion, esta debe de tenerlo los dos elementos
	 */
	@Test
	public void addPostInNewColletion() {
		snt.addPost(post1);
		snt.addPost(post2);
		List<Post> posts = snt.getPostForTesting();
		assertTrue(posts.contains(post1));
		assertTrue(posts.contains(post2));
	}
	
	/**
	 * Given: social network sin post
	 * When: se invoca al metodo con el parametro null
	 * Then: no es admitido el valor
	 */
	@Test
	public void addPostNull() {
		try {
			snt.addPost(null);
			fail("Debería haber fallado");
		}catch (IllegalArgumentException e) {
			assertEquals("post invalido",e.getMessage());
		}
	}
	
	/**
	 * Given: una coleccion con post
	 * When: se invoca al metodo
	 * Then: se añde a la coleccion
	 */
	@Test
	public void addPostInNotEmptyCollection() {
		snt2.addPost(post2);
		List <Post> posts = snt2.getPostForTesting();
		assertTrue(posts.contains(post1));
		assertTrue(posts.contains(post2));
		assertEquals(2,posts.size());
	}

}
