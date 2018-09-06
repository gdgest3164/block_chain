package com.openchain.simple.util;

import java.security.MessageDigest;

public class StringUtil {
	
	//�ؽ��� ���� �Լ�		�Է� �޾� �ؽ���(sha-256)���� ��ȯ  
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");		//��ȣȭ sha-256��� ���
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			
			for(int i=0; i< hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);		//0xff = 32��Ʈ��  ��ȯ
				if(hex.length() == 1) hexString.append('0');		//ù���۸� 0 �߰�
				
				hexString.append(hex);
			}
			return hexString.toString();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
