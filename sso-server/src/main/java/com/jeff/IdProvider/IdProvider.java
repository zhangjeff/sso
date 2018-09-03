package com.jeff.IdProvider;

import java.util.UUID;

/**
 * 生成token
 *  2018年08月30日11:05:14
 */
public class IdProvider {

	public static String createUUIDId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
