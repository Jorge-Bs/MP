package uo.mp2223.newsstand.service.serializers;

import java.util.LinkedList;
import java.util.List;

import uo.mp2223.newsstand.domain.Publication;

public class PublicationSerializer {

	public List<String> serialize(List<Publication> publications) {
		List<String> res = new LinkedList<>();
		for(Publication p: publications) {
			res.add( p.serialize() );
		}
		return res;
	}

}
