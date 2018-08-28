package com.skillregistry.skills;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class SkillsService {
	
	@Autowired
	public SkillsRepository repository;
	
	public Skill getSkillsByName(String name) {
		
		
		Skill sk = repository.findBySkillName(name);
		return sk;
	}
	
	public List <Skill> getSkillsByCategory(String category) {
		List<Skill> sk = repository.findBySkillCategory(category);
		return sk;
	}
	
	public List <Skill> getAllSkills() {
		List<Skill> skillList = repository.findAll();
		return skillList;
	}
	
	public void addSkills(Skill skill) {
		repository.save(skill);
		System.out.println("skill added" + skill.toString());
	}
	
	public void deleteSkills(Skill skill) {
		repository.delete(skill);
		System.out.println("skill deleted: " + skill.toString());
	}

}
