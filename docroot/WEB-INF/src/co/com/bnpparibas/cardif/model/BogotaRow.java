package co.com.bnpparibas.cardif.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BogotaRow implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CERTIFICATE_NUMBER")
	private Double certNumber;

	@Column(name = "PRODUCT_ID")
	private String prodId;

	@Column(name = "INSURED_NAME")
	private String name;

	@Column(name = "EFFECTIVE_DATE")
	private String initDate;

	@Column(name = "FINAL_DATE")
	private String finalDate;

	@Column(name = "PERSONAL_ID")
	private String id;

	public Double getCertNumber() {
		return certNumber;
	}

	public void setCertNumber(Double certNumber) {
		this.certNumber = certNumber;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

}
