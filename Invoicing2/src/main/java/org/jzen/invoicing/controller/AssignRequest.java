package org.jzen.invoicing.controller;

public class AssignRequest {

	String bundleID;
	String name;
	public String getBundleID() {
		return bundleID;
	}
	public void setBundleID(String bundleID) {
		this.bundleID = bundleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AssignRequest [bundleID=" + bundleID + ", name=" + name + "]";
	}
	
	
}
