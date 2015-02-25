package kr.pe.springwithmongodb.service;

import java.util.List;
import java.util.UUID;

import kr.pe.springwithmongodb.model.SWMModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SWMService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "employee";

	public List<SWMModel> listZipCode() {
		return mongoTemplate.findAll(SWMModel.class, COLLECTION_NAME);
	}
	
	public void addEmployee(SWMModel swmmodel) {
		if (!mongoTemplate.collectionExists(SWMModel.class)) {
			mongoTemplate.createCollection(SWMModel.class);
		}		
		swmmodel.set_id(UUID.randomUUID().toString());
		mongoTemplate.insert(swmmodel, COLLECTION_NAME);
	}
	
	public void updateEmployee(SWMModel swmmodel) {
		Query query = new Query();
		query.addCriteria(new Criteria("userid").is(swmmodel.getUserid()));
		Update update = new Update();
		update.set("name", swmmodel.getName());
		update.set("age", swmmodel.getAge());
		update.set("city", swmmodel.getCity());
		update.set("team", swmmodel.getTeam());
		update.set("phone", swmmodel.getPhone());
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);	
	}

	public void deleteEmployee(SWMModel swmmodel) {
		Query query = new Query(new Criteria("userid").is(swmmodel.getUserid()));
        mongoTemplate.remove(query, COLLECTION_NAME);
	}

}
