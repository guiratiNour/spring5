package com.nour.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nour.demo.entities.Album;
import com.nour.demo.entities.Chanson;
import com.nour.demo.services.ChansonService;

@Controller
public class ChansonController {
   @Autowired
	ChansonService chansonService;
   
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Album> albums=chansonService.getAllAlbums();
	    
		modelMap.addAttribute("chanson", new Chanson());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("albums", albums);
		modelMap.addAttribute("page",0);
		return "formChanson";
	}
	
	@RequestMapping("/saveChanson")
	public String saveChanson(@Valid Chanson chanson,
			 BindingResult bindingResult,@ModelAttribute("page") int pageFormPrevious,
			 @RequestParam(name="size",defaultValue="3") int size ,
			 RedirectAttributes redirectAttributes, ModelMap modelMap) 
	{int page;
		if (bindingResult.hasErrors()) {
	    	List<Album> albums = chansonService.getAllAlbums();
	    	modelMap.addAttribute("albums", albums);
	    	
	    	 modelMap.addAttribute("mode", "edit");
			return "formChanson";
	    }
		 if (chanson.getIdChanson()==null) //adding
		        page = chansonService.getAllChansons().size()/size; // calculer le nbr de pages
		    else //updating
		        page = pageFormPrevious;
		   
		 chansonService.saveChanson(chanson);
		   
		    redirectAttributes.addAttribute("page", page);
		    return "redirect:/ListeChansons";
	}
@RequestMapping("/ListeChansons")
public String ListeChansons(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "3") int size)
{
	Page<Chanson> fact = chansonService.getAllChansonsParPage(page, size);
	modelMap.addAttribute("chansons", fact);
	 modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeChansons";

}
@RequestMapping("/supprimerChanson")
public String supprimerChanson(@RequestParam("id") Long id, ModelMap modelMap,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "2") int size) { 
    chansonService.deleteChansonById(id);
    Page<Chanson> fact = chansonService.getAllChansonsParPage(page, size);
    modelMap.addAttribute("chansons", fact);
    modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    modelMap.addAttribute("size", size);

    return "ListeChansons";
}


@RequestMapping("/modifierChanson")
public String editerChanson(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam("page") int page)
{
Chanson f= chansonService.getChanson(id);
List<Album> albums=chansonService.getAllAlbums();
modelMap.addAttribute("chanson", f);
modelMap.addAttribute("mode", "edit");
modelMap.addAttribute("albums", albums);
modelMap.addAttribute("page",page);
return "formChanson";
}
@RequestMapping("/updateChanson")
public String updateChanson(@ModelAttribute("chanson") Chanson chanson,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
	 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 chanson.setDateCreation(dateCreation);
	 
	 chansonService.updateChanson(chanson);
	 List<Chanson> fact = chansonService.getAllChansons();
	 modelMap.addAttribute("chansons", fact);
	return "listeChansons";
	}
}