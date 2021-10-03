package com.model;




import javax.persistence.Embeddable;
import javax.persistence.*;



@Embeddable
public class Client {
	
	
	private int clientId;
	private String clientName;
	private String clientPlace;
	public Client(int clientId,String clientName, String clientPlace) {
		super();
		this.clientId=clientId;
		this.clientName = clientName;
		this.clientPlace = clientPlace;
	}
	
	public Client() {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPlace() {
		return clientPlace;
	}
	public void setClientPlace(String clientPlace) {
		this.clientPlace = clientPlace;
	}







}

