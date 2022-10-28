package com.wej.singer.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Singer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSinger;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomSinger;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String prenomSinger;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date dateNSinger;
	
	@ManyToOne
	private Band band;
	
	public Singer() {
	super();
	}
	public Singer(String nomSinger, String prenomSinger, Date dateNSinger ) {
	super();
	this.nomSinger = nomSinger;
	this.prenomSinger = prenomSinger;
	this.dateNSinger = dateNSinger;
	}
	
	public Long getIdSinger() {
		return idSinger;
		}
		public void setIdSinger(Long idSinger) {
		this.idSinger = idSinger;
		}
		public String getNomSinger() {
		return nomSinger;
		}
		public void setNomSinger(String nomSinger) {
		this.nomSinger = nomSinger;
		}
		public String getPrenomSinger() {
		return prenomSinger;
		}
		public void setPrenomSinger(String prenomSinger) {
		this.prenomSinger = prenomSinger;
		}
		public Date getDateNSinger() {
			return dateNSinger;
			}
			public void setDateNSinger(Date dateNSinger) {
			this.dateNSinger = dateNSinger;
			}
			
			
			
			
			@Override
			public String toString() {
			return "Singer [idSinger=" + idSinger + ", nomSinger=" +

			nomSinger + ", prenomSinger=" + prenomSinger

			+ ", age =" + dateNSinger +"]";

			}
			
			public Band getBand() {
				return band;
			}
			public void setBand(Band band2) {
				this.band = band2;
				
			}
}
