package uo.mp.lab03.socialnetwork.service.socialnetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.socialnetwork.model.Image;
import uo.mp.lab04.socialnetwork.model.Post;
import uo.mp.lab04.socialnetwork.model.TextMessage;
import uo.mp.lab04.socialnetwork.service.SocialNetwork;

public class FindPostByUserTest {
	private SocialNetwork snt;
	private Post post1;
	private Post post2;
	
	private ArrayList<Post> expected;
	private ArrayList<Post> real;
	
	@BeforeEach
	public void setUp(){
		snt = new SocialNetwork();
		expected = new ArrayList<>();
		post1 = new Image("user1","gatos.jpg","Gatos divertidos");
		post2 = new TextMessage("user2","Feliz día");
		snt.addPost(post1);
		snt.addPost(post2);
	}
	
	/**
	 * Given: Socialnetwok con post
	 * When: Se invoca al metodo con user1
	 * Then: Se devuelve una arrayList con los post de user1
	 */
	@Test
	public void findPostUserOne() {
		expected.add(post1);
		real=snt.findPostByUser("user1");
		assertEquals(expected,real);
	}
	
	
	/**
	 *Given: socialnetwork con post de 2 usuarios
	 *When: se invoca el metodo para un user3
	 *Given: el array resultante esta vacia
	 */
	@Test
	public void findPostUserWithoutPost() {
		real=snt.findPostByUser("user3");
		assertEquals(expected,real);
	}
	
	

	

}
