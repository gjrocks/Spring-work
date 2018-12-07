package org.jzen.invoicing.entity.enums;

public enum UserStatusType {
	
	ENABLED(1, "Enabled"), DISABLED(2, "Disabled"), DELETED(3, "Deleted");
	private String userStatus;
	private Integer statusId;

	UserStatusType(Integer statusId, String userStatus) {
		this.userStatus = userStatus;
		this.statusId = statusId;
	}

	public static String getUserStatus(Integer value) {
		if (value != null) {
			for (UserStatusType vt : values()) {
				if (value.equals(vt.getValue())) {
					return vt.userStatus;
				}
			}
		}

		return null;
	}

	public Integer getValue() {
		return this.statusId;
	}

}
