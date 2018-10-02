package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;

public class SalesOrderRequest {
	
	private BigDecimal id;
	private String status;
	private String custDocumentNumber;
	private String custDocumentType;
	private BigDecimal idcustomer;
	
	public SalesOrderRequest ()
	{
		
	}

	public SalesOrderRequest(BigDecimal id, String status, String custDocumentNumber, String custDocumentType, BigDecimal idcustomer) {
		super();
		this.id = id;
		this.status = status;
		this.custDocumentNumber = custDocumentNumber;
		this.custDocumentType = custDocumentType;
		this.idcustomer = idcustomer;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustDocumentNumber() {
		return custDocumentNumber;
	}

	public void setCustDocumentNumber(String custDocumentNumber) {
		this.custDocumentNumber = custDocumentNumber;
	}

	public String getCustDocumentType() {
		return custDocumentType;
	}

	public void setCustDocumentType(String custDocumentType) {
		this.custDocumentType = custDocumentType;
	}

	public BigDecimal getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(BigDecimal idcustomer) {
		this.idcustomer = idcustomer;
	}

	
}
