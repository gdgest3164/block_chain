package com.openchain.simple.core;
import java.util.Date;

import com.openchain.simple.util.StringUtil;

public class Block {
	//�� ===================================
	public String hash;				//�ؽ���
	public String previousHash;		//���� ���� �ؽ���
	private String data;			//������
	private long timestamp;			//����ð�
	private int nonce;
	//=======================================
	
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	//[previousHash + timestamp + nonce + data] -> �ؽ������� ��ȯ
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(previousHash + Long.toString(timestamp) + Integer.toString(nonce) + data);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0');
		
		while(!hash.substring(0,difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
			
			System.out.printf("\nGEN Hash #%d : %s", nonce, hash);
		}
		
		System.out.println("\nä�� ����!!! : "+ hash);
	}
}