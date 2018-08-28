package com.skillregistry.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillsApplication implements CommandLineRunner{

	@Autowired
	public SkillsRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SkillsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
	
		Skill s1 = new Skill("java","Technical");
		Skill s2 = new Skill("VB","Technical");	
		repository.save(s1);
		repository.save(s2);
		//repository.save(new Skill("Agile","Management"));
		
		// fetch all skills
		System.out.println("Skills found with findAll():");
		System.out.println("-------------------------------");
		for (Skill sk : repository.findAll()) {
			System.out.println(sk);
		}
		
		Skill sk2 = repository.findBySkillName("java");
		System.out.println(sk2);
		
	}
	
}
