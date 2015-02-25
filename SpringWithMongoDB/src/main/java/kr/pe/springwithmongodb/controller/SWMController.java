package kr.pe.springwithmongodb.controller;

import java.util.ArrayList;

import kr.pe.springwithmongodb.model.SWMModel;
import kr.pe.springwithmongodb.service.SWMService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SWMController {

	@Autowired
	private SWMService swmservice;

	private static final Logger logger = LoggerFactory.getLogger(SWMController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEmployeeList(ModelMap model) {  
		model.addAttribute("employeeList", swmservice.listZipCode());
		return "main";
	}
	
	@RequestMapping(value = "/errormsg", method = RequestMethod.GET)
	public String getErrorMsg(ModelMap model) {  
		model.addAttribute("msg", "Plase Enter Your ID and Name");
		model.addAttribute("url", "/springwithmongodb/");
		return "errormsg";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	public View createEmployee(@ModelAttribute SWMModel swmmodel, ModelMap model) {
		ArrayList<String> useridList = new ArrayList<String>();
		Boolean bool = new Boolean(true);	

		// userid, name이 null인지 아닌지 validation
		if(swmmodel.getUserid().equals("") || swmmodel.getName().equals("")) {
			return new RedirectView("/springwithmongodb/errormsg");
		} else {
		
			for(int i=0; i<swmservice.listZipCode().size(); i++) {
				useridList.add(swmservice.listZipCode().get(i).getUserid());
			}

			if(swmservice.listZipCode().size() > 0) {
				for(int i=0; i<swmservice.listZipCode().size(); i++) {
					if(useridList.get(i).equals(swmmodel.getUserid())) {
						bool = true;
						break;
					} else {
						bool = false;
					}
				}

				if(bool==true) {
					swmservice.updateEmployee(swmmodel);	
				} else {
					swmservice.addEmployee(swmmodel);
				}
			} else {
				swmservice.addEmployee(swmmodel);
			}
		}
		return new RedirectView("/springwithmongodb/");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)  
	public View deleteEmployee(@ModelAttribute SWMModel swmmodel, ModelMap model) {  
		swmservice.deleteEmployee(swmmodel);  
		return new RedirectView("/springwithmongodb/");  
	}

}
