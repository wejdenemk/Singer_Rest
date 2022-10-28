package com.wej.singer.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wej.singer.entities.Band;

public interface BandRepository extends JpaRepository<Band, Long> {

}
