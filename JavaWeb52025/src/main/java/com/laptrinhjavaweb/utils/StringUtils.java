package com.laptrinhjavaweb.utils;

public class StringUtils {

	public static boolean isNullOrEmpty(String value) {
		if (value != null && value != "") {
			return false;
		}
		return true;
	}

	public static boolean isNotBlank(String value) {
		if (value != "") {
			return false;
		}
		return true;
	}

	public static StringBuilder convertString(StringBuilder value) {
		if (value.length() > 0) {
			value.append(", ");
		}
		return value;
	}

}
