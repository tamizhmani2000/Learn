/*sample service to deploy into docker containers s*/
package com.mydocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/rest/details")
class DockerService{
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getMyDetails() {
		return "Hello Docker World";
	}
}
