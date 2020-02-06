package hh.swd20.tehtava22.web;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import hh.swd20.tehtava22.domain.Student;

@Controller
public class StudentController {

	@GetMapping("/hello")
	public String greetingForm(Model model) {

		model.addAttribute("student", new Student());
		
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student ("Mauno","Mato"));
		students.add(new Student ("Taneli","Testaaja"));
		model.addAttribute("students",students);
		return "studentList";
	}
	
}
