package road.to.cto.HelloWorld.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import road.to.cto.HelloWorld.custom.dao.CustomerDAO;
import road.to.cto.HelloWorld.custom.model.Customer;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
	    ApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Module.xml");
	    CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	    Customer customer1 = customerDAO.findByCustomerId(1);
	    ModelAndView mav = new ModelAndView("home");
	    mav.addObject("name", customer1.getName());
	    return mav;
		//return new ModelAndView("home");
	}
}
