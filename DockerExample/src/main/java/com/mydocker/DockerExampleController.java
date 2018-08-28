package com.mydocker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
@RequestMapping(value="/services")
public class DockerExampleController {
	
	@Autowired
	private DockerExampleService dockerService;
	
	@Value("${info.version}")
	private String version;
	
	@Value("${info.build}")
	private String build;
	

	@Value("${services.commerce}")
	private String serviceCommerce;

	
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getMyDetails() {
		return "Hello Docker World2.2";
		
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String getInfo() {
		
		String info = "Version:" + version + "<BR>";
		info = info + "Build Number:" + build;
		info = info + "services:" + serviceCommerce;
		
		return info;
	}
	
	@RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }
	
	@RequestMapping("/services/instance")
    public String instance() {
		Application application 
	      = eurekaClient.getApplication("spring-cloud-eureka-client");
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    return hostname + port;
    }
	
	@RequestMapping("/products")
    public String getProducts()
    {
		/* service discovery */
		
		//ServiceInstance sinst = discoveryClient.getInstances(serviceCommerce).get(0);
		//String url = sinst.getUri().toString() + "/rest/product/";
		String url = "http://localhost:8080/rest/product/";
		System.out.println("URL=" + url);
		
		String responseBody = dockerService.getProducts(url);
	    return responseBody;
    }
	
	@RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
	    return this.discoveryClient.getInstances(applicationName);
    }
}
