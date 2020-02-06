package hh.sdw20.tehtava23.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sdw20.tehtava23.domain.Friend;

@Controller
public class FriendController {
	
	List<Friend> friends = new ArrayList<Friend>();

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listFriends(Model model) {
		
		
		friends.add(new Friend("Kate", "Cole"));
		friends.add(new Friend("Dan", "Brown"));
		friends.add(new Friend("Mike", "Mars"));
		
		model.addAttribute("friend", new Friend());
		
		model.addAttribute("friends", friends);

		
		return "friendlist";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String inputFriends(@ModelAttribute Friend friend, Model model, @RequestParam(name="firstName") String fname, @RequestParam(name="lastName") String lname) {
		
		friends.add(new Friend(fname, lname));
		
		model.addAttribute("friend", friend);
		
		
		
		return "friendlist";
	}
	
	
}
