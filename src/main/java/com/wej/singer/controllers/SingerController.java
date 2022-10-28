package com.wej.singer.controllers;

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

import com.wej.singer.entities.Band;
import com.wej.singer.entities.Singer;
import com.wej.singer.service.BandService;

import com.wej.singer.service.SingerService;


@Controller
public class SingerController {

	@Autowired
	SingerService singerService;
	
	@Autowired
	BandService bandService;
	

	
	@RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<Band> bands = bandService.getAllBands();
        Singer singer = new Singer();
        Band band = new Band();
        band = bands.get(0); // prendre la première catégorie de la liste
        singer.setBand(band); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
        modelMap.addAttribute("singer",singer);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("bands", bands);
        return "formSinger";
    }
	

	
	
	@RequestMapping("/saveSinger")
	public String saveSinger(@Valid Singer singer,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formSinger";
	singerService.saveSinger(singer);
	return "redirect:/ListeSinger";
	}
	
	@RequestMapping("/ListeSinger")
	public String listeSingers(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
		List<Band> bands = bandService.findAll();
		modelMap.addAttribute("bands", bands);
	Page<Singer> singers = singerService.getAllSingersParPage(page, size);
	modelMap.addAttribute("singers", singers);

	modelMap.addAttribute("pages", new int[singers.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeSinger";
	}
	
	@RequestMapping("/supprimerSinger")
	public String supprimerSinger(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	singerService.deleteSingerById(id);
	Page<Singer> singers = singerService.getAllSingersParPage(page,size);

	modelMap.addAttribute("singers", singers);
	modelMap.addAttribute("pages", new int[singers.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeSinger";
	}
	
	@RequestMapping("/modifierSinger")
	public String editerSinger(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Singer p= singerService.getSinger(id);
	List<Band> bands = bandService.findAll();
	bands.remove(p.getBand());
	modelMap.addAttribute("bands", bands);
	modelMap.addAttribute("singer", p);
	modelMap.addAttribute("mode", "edit");
	return "formSinger";
	}
	
	@RequestMapping("/updateSinger")
	public String updateSinger(@ModelAttribute("singer") Singer singer,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
	//conversion de la date
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	singer.setDateNSinger(dateCreation);
	singerService.updateSinger(singer);
	List<Singer> singers = singerService.getAllSingers();
	modelMap.addAttribute("singers", singers);
	return "listeSinger";
	
	}
	
	
	
	
	@RequestMapping("/ListeBands")
	public String listeBands(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Band> bands = bandService.getAllBandsParPage(page, size);
	modelMap.addAttribute("bands", bands);

	modelMap.addAttribute("pages", new int[bands.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeBand";
	}
	
	@RequestMapping("/showCreateB")
	public String showCreateB(ModelMap modelMap)
	{
	modelMap.addAttribute("band", new Band());
	modelMap.addAttribute("mode", "new");
	return "formBand";
	}
	
	@RequestMapping("/saveBand")
	public String saveBand(@Valid Band band,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formBand";
	bandService.saveBand(band);
	return "redirect:/ListeBands";
	}
	
	
	@RequestMapping("/modifierBand")
	public String editerBand(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Band b = bandService.getBand(id);
	modelMap.addAttribute("band", b);
	modelMap.addAttribute("mode", "edit");
	return "formBand";
	}
	
	
	@RequestMapping("/supprimerBand")
	public String supprimerBand(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{ 
	bandService.deleteBandById(id);
	List<Band> cats = bandService.findAll();
	modelMap.addAttribute("bands", cats);
	return "redirect:/ListeBands";
	}
	
	@RequestMapping("/search")
	public String rechNom(@RequestParam("nom") String nom,
	ModelMap modelMap)
	{
		List<Band> bands = bandService.findAll();
		modelMap.addAttribute("bands", bands);
	List<Singer> singers = singerService.findByNomSinger(nom);
	modelMap.addAttribute("singers",singers);
	modelMap.addAttribute("mode", "SearchNomS");
	return "listeSinger";
	}
	
		@RequestMapping("/searchBand")
	public String rechBand(@RequestParam("band") Long band,ModelMap modelMap)
	{
		Band bands = new Band();
		bands.setIdBand(band);
	List<Band> bands2 = bandService.findAll();
	modelMap.addAttribute("bands", bands2);
	List<Singer> sing = singerService.findByBand(bands);
	modelMap.addAttribute("singers",sing);
	modelMap.addAttribute("mode", "SearchBand");
	return "listeSinger";
	}
		
		
		/*User Crud*/
		


		
}
