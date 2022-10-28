package com.wej.singer.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSinger", types = { Singer.class })
public interface SingerProjection {
public String getNomSinger();
}

