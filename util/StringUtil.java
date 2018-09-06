package com.openchain.simple.util;

import java.security.MessageDigest;

public class StringUtil {
	
	//해쉬값 생성 함수		입력 받아 해쉬값(sha-256)으로 변환  
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");		//암호화 sha-256방식 사용
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			
			for(int i=0; i< hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);		//0xff = 32비트로  변환
				if(hex.length() == 1) hexString.append('0');		//첫시작만 0 추가
				
				hexString.append(hex);
			}
			return hexString.toString();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
