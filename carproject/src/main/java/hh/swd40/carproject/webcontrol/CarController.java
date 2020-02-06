package hh.swd40.carproject.webcontrol;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd40.carproject.domain.Car;	
@Controller

public class CarController {


	
//metodi palauttaa autolistauksen selaimelle
@RequestMapping("/allcars")
public String getAllCars(Model model){
	
	
	// ei vielä ostata hakea autoja tietokannasta, joten tuotetaan autolista tässä
	List<Car> cars = new ArrayList<Car>(); // uusi tyhjä lista
	cars.add(new Car("Saab", 1990));
	cars.add(new Car("Testla", 2014));
	// 1. autolista talletetaan model-mappiin, jonka tiedot näkyvät thymeleaf-templatelle
	model.addAttribute("cars", cars);
	// 2. sopiva thymeleaf-templaten nimi palautetaan displatcher servletille
	return "carlist"; //palauttaa carlist.html -templaten nimen
	
	
	
}


//metodi palauttaa selaimeen tyhjän autolomakkeen
@RequestMapping(value="/newcar", method = RequestMethod.GET)
public String getNewCarForm(Model model) {
	
	model.addAttribute("car", new Car());
	return "newcarform"; // newcarform.html
}

//metodi vastaanottaa autolomakkeelta tulleet tiedot ja tallentaa ne tietokantaan


@RequestMapping(value= "/savecar", method = RequestMethod.POST)
public String saveCar(@ModelAttribute Car car, Model model) {
	// ei osata vielä tallentaa lomakkeella annetun auton tietoja tietokantaan.
	// annetaan auton tiedot raportti-templatelle
	model.addAttribute("car", car);
	return "carreport";
}


}
