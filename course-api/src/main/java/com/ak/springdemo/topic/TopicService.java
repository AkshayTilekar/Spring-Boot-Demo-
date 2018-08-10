package com.ak.springdemo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Framework Description"),
			new Topic("Java","Java Framework","Java Framework Description"),
			new Topic("Angular","Angular Framework","Angular Framework Description")
			));
	
	public List<Topic> getAllTopics(){
		return topicList;
	}
	
	public Topic getTopic(String id){
		return topicList.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public void add (Topic topic ) {
		topicList.add(topic);
	}

	public void update(Topic topic,String id ) {
		for (int i =0; i < topicList.size();i++) {
			Topic t = topicList.get(i);
			if(t.getId().equals(id)) {
				topicList.set(i, topic);
			}
		}
		
	}

	public void delete(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
}
