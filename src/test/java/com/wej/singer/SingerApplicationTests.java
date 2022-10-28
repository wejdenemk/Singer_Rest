package com.wej.singer;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.wej.singer.entities.Band;
import com.wej.singer.entities.Singer;
import com.wej.singer.repos.SingerRepository;
import com.wej.singer.service.SingerService;

@SpringBootTest
class SingerApplicationTests {

	@Autowired
	private SingerRepository singerRepository;
	
	@Autowired
	private SingerService singerService;
	
	@Test
	public void testCreateSinger() {
	Singer singer = new Singer("namekk","name",new Date());
	singerRepository.save(singer);
	}
	
	@Test
	public void testFindSinger()
	{
	Singer p = singerRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateSinger()
	{
	Singer p = singerRepository.findById(1L).get();
	p.setPrenomSinger("prenom");
	singerRepository.save(p);
	}
	
	@Test
	public void testDeleteSinger()
	{
	singerRepository.deleteById(2L);;
	}
	
	
	@Test
	public void testFindByNomSinger()
	{
	List<Singer> prods = singerRepository.findByNomSinger("wej");
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomContains ()
	{
	List<Singer> prods= singerRepository.findByNomSingerContains("w");
	for (Singer p : prods)
	{
		System.out.println(p);
	}}
	
	@Test
	public void testfindByNomPr()
	{
	List<Singer> prods = singerRepository.findByNomPr("W", "");
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testfindByBand()
	{
	Band cat = new Band();
	cat.setIdBand(1L);
	List<Singer> prods = singerRepository.findByBand(cat);
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void findByBandIdCat()
	{
	List<Singer> prods = singerRepository.findByBandIdBand(1L);
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomSingerAsc()
	{
	List<Singer> prods = singerRepository.findByOrderByNomSingerAsc();
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierSingersNomsPrs()
	{
	List<Singer> prods = singerRepository.trierSingersNomsPrs();
	for (Singer p : prods)
	{
	System.out.println(p);
	}
	}
	/************************************************/
	
	@Test
	public void testListerTousSinger()
	{
	List<Singer> singers = singerRepository.findAll();
	for (Singer p : singers)
	{
	System.out.println(p);
	}

	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Singer> singers = singerService.getAllSingersParPage(0,2);
	System.out.println(singers.getSize());
	System.out.println(singers.getTotalElements());
	System.out.println(singers.getTotalPages());
	singers.getContent().forEach(s -> {System.out.println(s.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	

}
