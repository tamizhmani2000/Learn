package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CaptchaValidationService;
import com.example.demo.Model.CaptchaModel;

@Controller
public class MyController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }
   
   @PostMapping("/check")
   public void validate(@RequestBody String captcha) {
	   
	   if (null!=captcha && captcha.length() > 0) {
		   String CaptchaResponse=captcha.substring(21, captcha.length()-1);
		   System.out.println(CaptchaResponse);
		   System.out.println("Captcha Validation:" + CaptchaValidationService.getInstance().isValidResponse(CaptchaResponse));
		
	   }
      
   }
}