package hh.swd20.tehtava21.webcontrol;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class HelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(value="firstname")String firstname, Model name, @RequestParam(value="age")int years, Model age) {
	name.addAttribute("firstname",firstname);
	age.addAttribute("age",years);
	
	if (years < 18) {
		return "tooyoung";
	}else {
		return "hello";
	}
	
	} 
	
}
