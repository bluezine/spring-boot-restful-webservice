package kr.co.bluezine;

import java.util.HashMap;
import java.util.Map;

import kr.co.bluezine.service.SugangService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class WebApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    
    @Autowired
    @Qualifier("SugangServiceImpl")
    private SugangService sugangService;
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView main() {
    	ModelAndView model = new ModelAndView("index");
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("result", null);
    	sugangService.deptList(map);
    	model.addObject("asdf", map.get("result").toString());
    	return model;
    }
}
