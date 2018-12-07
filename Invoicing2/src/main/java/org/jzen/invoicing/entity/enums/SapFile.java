package org.jzen.invoicing.entity.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_sapfile")
public class SapFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sapfile_id",nullable = false)
	private Long id;
	private String fileName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
