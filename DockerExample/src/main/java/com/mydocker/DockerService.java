/*sample service to deploy into docker containers s*/
package com.mydocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/rest/details")
class DockerService{
	
	@Value("${info.version}")
	private String version;
	
	@Value("${info.build}")
	private String build;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getMyDetails() {
		return "Hello Docker World2";
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String getInfo() {
		
		String info = "Version:" + version + "<BR>";
		info = info + "Build Number:" + build;
		
		return info;
	}
}
