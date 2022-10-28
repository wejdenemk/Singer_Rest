package com.wej.singer.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wej.singer.entities.Band;
import com.wej.singer.entities.Singer;

@RepositoryRestResource(path = "rest")
	public interface SingerRepository extends JpaRepository<Singer, Long> {

		List<Singer> findByNomSinger(String nom);
		List<Singer> findByNomSingerContains(String nom);

		List<Singer> findByBand(Band bands);
		
		List<Singer> findByBandIdBand(Long id);

		
		/*@Query("select p from Singer p where p.band = ?1")
		List<Singer> findByBand (Band categorie);*/

		
		/*@Query("select p from Singer p where p.nomSinger like %?1 and p.prenomSinger like %?2")
		List<Singer> findByNomPr (String nom, String prix);*/

		@Query("select p from Singer p where p.nomSinger like %:nom and p.prenomSinger like %:prix")
		List<Singer> findByNomPr (@Param("nom") String nom,@Param("prix") String prix);

		List<Singer> findByOrderByNomSingerAsc();

		@Query("select p from Singer p order by p.nomSinger ASC, p.prenomSinger DESC")
		List<Singer> trierSingersNomsPrs ();
		

		
	
	}
