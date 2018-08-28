package com.skillregistry.skills;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/skills")


public class SkillsController {
	
	@Autowired
	private SkillsService skillservice;
	
	@RequestMapping(value="/view/{name}",method=RequestMethod.GET)
	public Skill getSkillByName(@PathVariable String name) {
		Skill sk = skillservice.getSkillsByName(name);
		return sk;
	}
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public List <Skill> getAllSkills() {
		List<Skill> skillList = skillservice.getAllSkills();
		return skillList;
	}
	
	@RequestMapping(value="/viewall/{category}",method=RequestMethod.GET)
	public List <Skill> getAllSkillsByCategory(@PathVariable String category) {
		List<Skill> skillList = skillservice.getSkillsByCategory(category);
		return skillList;
	}
	
	@RequestMapping(value="/addskill",method=RequestMethod.POST, consumes = "application/json")
	public void addSkills(@RequestBody Skill skill) {
		skillservice.addSkills(skill);
	}
	
	@RequestMapping(value="/deleteskill",method=RequestMethod.DELETE, consumes = "application/json")
	public void updateSkills(@RequestBody Skill skill) {
		skillservice.deleteSkills(skill);
	}
	
}
