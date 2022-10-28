package com.wej.singer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wej.singer.entities.Band;

public interface BandService {

	
	Band saveBand(Band p);
	Band updateBand(Band p);
	void deleteBand(Band p);
	void deleteBandById(Long id);
	Band getBand(Long id);
	List<Band> getAllBands();
	Page<Band> getAllBandsParPage(int page, int size);
	List<Band> findAll();
}
