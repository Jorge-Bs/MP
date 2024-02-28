package uo.mp.lab04.socialnetwork.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab04.socialnetwork.model.Post;

public class SocialNetwork {
	private ArrayList<Post> posts = new ArrayList<>();
	
	/**
	 * Añade post
	 * @param post
	 */
	public void addPost(Post post) {
		ArgumentChecks.isTrue(post!=null,"post invalido");
		posts.add(post);
	}
	
	/**
	 * Lista todos los post y los almacena en el out dado como parametro
	 * @param out
	 */
	public void listAllPost(PrintStream out) {
		if(posts.size()==0) {
			out.println("No post");
		}
		else {
			for(Post post:posts) {
				out.println(post.toString());
			}
		}
	}
	
	/**
	 * Crea un arraylist con todos los post de un usario dado como parametro
	 * @param userId
	 * @return ArrayList de Post con los post del usuario
	 */
	public ArrayList<Post> findPostByUser(String userId){
		ArrayList<Post> userPost = new ArrayList<>();
		for(Post post:posts) {
			if(post.getUser()==userId) {
				userPost.add(post);
			}
		}
		return userPost;
	}
	
	/**
	 * Crea una lista con todos los post, para los test
	 * @return a lis with post
	 */
	public List<Post> getPostForTesting(){
		return new ArrayList<Post>(posts);
	}
	
	
	/**
	 * Devuelve en formato html los post
	 */
	public String toHtmlFormat() {
		StringBuilder sb = new StringBuilder();
		sb.append("Post en formato html\n");
		for(Post post:posts) {
			sb.append(post.toHtmlFormat()+"\n");
		}
		return sb.toString();
	}
}
