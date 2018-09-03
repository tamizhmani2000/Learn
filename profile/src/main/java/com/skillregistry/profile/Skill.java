package com.skillregistry.profile;

import java.io.Serializable;

public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	public Skill() {}
	
	private String skillName;
	
	private String skillCategory;
	
	public String getSkillName() {
		return this.skillName;
	}
	
	public void setSkillName(String skillName) {
		this.skillName=skillName;
	}
	
	public String getSkillCategory() {
		return this.skillCategory;
	}
	
	public void setSkillCategory(String skillCategory) {
		this.skillCategory=skillCategory;
	}
	
	public Skill(String Name,String Category) {
		
		this.skillName=Name;
		this.skillCategory = Category;
	}
	
	
	
	@Override
	public String toString() {
		return "SkillName: "+skillName +", Category:"+skillCategory;
	}
}
