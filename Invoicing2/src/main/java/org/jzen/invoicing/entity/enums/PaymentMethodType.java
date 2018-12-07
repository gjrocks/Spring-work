package org.jzen.invoicing.entity.enums;

public enum PaymentMethodType {

	INVOICE(1, "Invoice"), DD(2, "Direct Debit"), PREPAID(3, "Pre-paid"), CROSSCHARGE(4, "Cross-charge"), SAGEPAY(5,
			"Sagepay");
	private String paymentMethod;
	private Integer paymentMethodCode;

	PaymentMethodType(Integer paymentMethodCode, String paymentMethod) {
		this.paymentMethod = paymentMethod;
		this.paymentMethodCode = paymentMethodCode;
	}

	public static String getPaymentMethod(Integer value) {
		if (value != null) {
			for (PaymentMethodType vt : values()) {
				if (value.equals(vt.getValue())) {
					return vt.paymentMethod;
				}
			}
		}

		return null;
	}

	public Integer getValue() {
		return this.paymentMethodCode;
	}
}
