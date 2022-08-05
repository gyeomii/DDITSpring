package com.jsp.controller;

import java.util.UUID;

public class MakeFileName {
	//동일한 파일명 정책을 하기위해서 따로 클래스를 만듦
	//저장되는 파일명을 만드는 규칙
	public static String toUUIDFileName(String fileName, String delimeter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimeter + fileName;
	}
}
