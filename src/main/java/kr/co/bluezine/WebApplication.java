package kr.co.bluezine;

import java.util.ArrayList;
import java.util.List;

import kr.co.bluezine.dao.User;
import kr.co.bluezine.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@RequestMapping(value = "/")
public class WebApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);
	
    public static void main(String[] args) {
    	logger.debug("------------->Web Application Starting...");
        SpringApplication.run(WebApplication.class, args);
    }
    
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView main() {
    	ModelAndView model = new ModelAndView("index");
    	List<User> users = new ArrayList<User>();
    	model.addObject("userList", users = userService.getUsers());
    	return model;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUSer(@PathVariable String id) {
    	return userService.getUser(id);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public User insert(@RequestBody User user) {
    	userService.insertUser(user);
    	return userService.getUser(user.getId());
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    public User update(@RequestBody User user) {
    	userService.updateUser(user);
    	return userService.getUser(user.getId());
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    public User delete(@RequestBody User user) {
    	userService.deleteUser(user);
    	return userService.getUser(user.getId());
    }
}
