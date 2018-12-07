package org.jzen.invoicing.entity.enums;

public enum SendMethodType {


	SYSTEM( "1", "System"), EMAIL("2", "Email"), POST("3", "Post"), SAP("4", "SAP");
	
	
	private String sendMethod;
	private String sendMethodCode;

	SendMethodType(String sendMethodCode, String sendMethod) {
		this.sendMethod = sendMethod;
		this.sendMethodCode = sendMethodCode;
	}

	public static String getSendMethod(String value) {
		if (value != null) {
			for (SendMethodType vt : values()) {
				if (value.equals(vt.getValue())) {
					return vt.sendMethod;
				}
			}
		}

		return null;
	}

	public String getValue() {
		return this.sendMethodCode;
	}
}
