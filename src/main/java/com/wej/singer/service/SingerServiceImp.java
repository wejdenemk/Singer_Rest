package com.wej.singer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wej.singer.entities.Band;
import com.wej.singer.entities.Singer;
import com.wej.singer.repos.SingerRepository;


@Service
public class SingerServiceImp implements SingerService {

	@Autowired
	SingerRepository singerRepository;
	
	@Override
	public Singer saveSinger(Singer p) {
		return singerRepository.save(p);
	}

	@Override
	public Singer updateSinger(Singer p) {
		return singerRepository.save(p);
	}

	@Override
	public void deleteSinger(Singer p) {
		singerRepository.delete(p);
	}

	@Override
	public void deleteSingerById(Long id) {
		singerRepository.deleteById(id);
		
	}

	@Override
	public Singer getSinger(Long id) {
		return singerRepository.findById(id).get();	}

	@Override
	public List<Singer> getAllSingers() {
		return singerRepository.findAll();
	}

	@Override
	public Page<Singer> getAllSingersParPage(int page, int size) {
		return singerRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Singer> findByNomSinger(String nom) {
		return singerRepository.findByNomSinger(nom);
	}

	@Override
	public List<Singer> findByBand(Band bands) {
		return singerRepository.findByBand(bands);
	}

	@Override
	public List<Singer> findByNomSingerContains(String nom) {
		return singerRepository.findByNomSingerContains(nom);
	}

	@Override
	public List<Singer> findByNomPr(String nom, String pre) {
		return singerRepository.findByNomPr(nom, pre);
	}

	@Override
	public List<Singer> findByBandIdBand(Long id) {
		return singerRepository.findByBandIdBand(id);
	}

	@Override
	public List<Singer> findByOrderByNomSingerAsc() {
		return singerRepository.findByOrderByNomSingerAsc();
	}

	@Override
	public List<Singer> trierSingersNomsPrs() {
		return singerRepository.trierSingersNomsPrs();
	}
	

}
