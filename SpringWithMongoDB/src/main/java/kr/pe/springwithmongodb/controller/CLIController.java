package kr.pe.springwithmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CLIController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/cli", method = RequestMethod.GET)
	public String cliHome(ModelMap model) {
		
		
		return "cli";
	}
}
