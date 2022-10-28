package com.wej.singer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wej.singer.entities.Band;
import com.wej.singer.repos.BandRepository;

@Service
public class BandServiceImp implements BandService {

	
	@Autowired
	BandRepository bandRepository;
	
	@Override
    public List <Band> findAll() {
        return bandRepository.findAll();
    }
	
	@Override
	public Band saveBand(Band p) {
		return bandRepository.save(p);
	}

	@Override
	public Band updateBand(Band p) {
		return bandRepository.save(p);
	}

	@Override
	public void deleteBand(Band p) {
		bandRepository.delete(p);
	}

	@Override
	public void deleteBandById(Long id) {
		bandRepository.deleteById(id);
	}

	@Override
	public Band getBand(Long id) {
		return bandRepository.findById(id).get();
	}

	@Override
	public List<Band> getAllBands() {
		return bandRepository.findAll();
	}

	@Override
	public Page<Band> getAllBandsParPage(int page, int size) {
		return bandRepository.findAll(PageRequest.of(page, size));
	}

	
}
