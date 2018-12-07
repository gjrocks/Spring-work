package org.jzen.invoicing.entity.enums;

public enum InvoiceStatus {

	PENDING(1, "Pending"), AUTHORISED(2, "Authorised"), CANCELLED(3, "Cancelled"), SENT(4, "Sent"), REGENERATED(5,
			"Regenerated");
	private String status;
	private Integer statusCode;

	InvoiceStatus(Integer statusCode, String status) {
		this.status = status;
		this.statusCode = statusCode;
	}

	public static String getStatus(Integer value) {
		if (value != null) {
			for (InvoiceStatus vt : values()) {
				if (value.equals(vt.getValue())) {
					return vt.status;
				}
			}
		}

		return null;
	}

	public Integer getValue() {
		return this.statusCode;
	}

	public static InvoiceStatus getInvoiceStatus(String status) {

		if (status != null) {
			try {
				return InvoiceStatus.valueOf(status);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	public String getInvoiceStatus() {
		return this.status;
	}
}
