package com.wej.singer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wej.singer.entities.Band;
import com.wej.singer.entities.Singer;

public interface SingerService {

	Singer saveSinger(Singer p);
	Singer updateSinger(Singer p);
	void deleteSinger(Singer p);
	void deleteSingerById(Long id);
	Singer getSinger(Long id);
	List<Singer> getAllSingers();
	Page<Singer> getAllSingersParPage(int page, int size);
	List<Singer> findByNomSinger(String nom);
	List<Singer> findByBand(Band bands);
	
	List<Singer> findByNomSingerContains(String nom);
	List<Singer> findByNomPr (String nom, String pre);
	List<Singer> findByBandIdBand(Long id);
	List<Singer> findByOrderByNomSingerAsc();
	List<Singer> trierSingersNomsPrs();

}
