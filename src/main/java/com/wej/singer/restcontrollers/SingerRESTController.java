package com.wej.singer.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wej.singer.entities.Singer;
import com.wej.singer.service.SingerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SingerRESTController {
	
@Autowired
SingerService singerService;

@RequestMapping(method = RequestMethod.GET)
public List<Singer> getAllProduits() {
return singerService.getAllSingers();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Singer getSingerById(@PathVariable("id") Long id) {
return singerService.getSinger(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Singer createProduit(@RequestBody Singer singer) {
return singerService.saveSinger(singer);
}

@RequestMapping(method = RequestMethod.PUT)
public Singer updateSinger(@RequestBody Singer singer) {
return singerService.updateSinger(singer);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteSinger(@PathVariable("id") Long id)
{
singerService.deleteSingerById(id);
}

@RequestMapping(value="/singband/{idBand}",method = RequestMethod.GET)
public List<Singer>  getSingersByBandId(@PathVariable("idBand") Long idBand) {
return singerService.findByBandIdBand(idBand);
}

@RequestMapping(value="/singsByName/{nom}",method = RequestMethod.GET)
public List<Singer> findByNomSingerContains(@PathVariable("nom") String nom) {
return singerService.findByNomSingerContains(nom);
}

}