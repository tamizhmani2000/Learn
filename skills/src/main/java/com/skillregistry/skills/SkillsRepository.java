package com.skillregistry.skills;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillsRepository extends MongoRepository<Skill, String> {
	
	public Skill findBySkillName(String name);
    public List<Skill> findBySkillCategory(String category);

}
