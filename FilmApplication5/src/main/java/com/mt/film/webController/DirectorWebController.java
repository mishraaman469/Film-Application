package com.mt.film.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/user")
public class DirectorWebController {

	/*@GetMapping("/admin")
	public String admin() {
		return ("<h2>hii</h2>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h2>hii</h2>");
	}*/

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/director")
	public String postDirector() {
		return "formDirector";
	}

	@GetMapping("/film")
	public String postFilm() {
		return "form";
	}

	@GetMapping("/displayDirector")
	public String displayDirector() {
		return "GetFormDirector";
	}

	@GetMapping("/deleteMovie")
	public String deleteMoovie() {
		return "deleteMovie";
	}

	@GetMapping("/displayMovie")
	public String displayMovie() {
		return "GetFormMovie";
	}

	@GetMapping("/updateDirector")
	public String update() {
		return "updateDirector";
	}

}
