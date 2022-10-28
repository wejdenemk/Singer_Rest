package com.wej.singer.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Band {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBand;
	
	private String nomBand;
	private String typeMBand;
	
	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<Singer> singers;

	
	public Band() {}
	public Band(String nomBand, String typeMBand, List<Singer> singers)
	{

	super();
	this.nomBand = nomBand;
	this.typeMBand = typeMBand;
	this.singers = singers;
	}
	
	public Long getIdBand() {
		return idBand;
		}
		public void setIdBand(Long idBand) {
		this.idBand = idBand;
		}
		public String getNomBand() {
		return nomBand;
		}
		public void setNomBand(String nomBand) {
		this.nomBand = nomBand;
		}
		public String getTypeMBand() {
		return typeMBand;
		}
		public void setTypeMBand(String typeMBand) {
		this.typeMBand = typeMBand;
		}
		public List<Singer> getSingers() {
		return singers;
		}
		public void setProduits(List<Singer> singers) {
			this.singers = singers;
			}
}
