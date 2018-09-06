package com.openchain.simple.core;
import java.util.Date;

import com.openchain.simple.util.StringUtil;

public class Block {
	//블럭 ===================================
	public String hash;				//해쉬값
	public String previousHash;		//이전 블럭의 해쉬값
	private String data;			//데이터
	private long timestamp;			//현재시간
	private int nonce;
	//=======================================
	
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	//[previousHash + timestamp + nonce + data] -> 해쉬값으로 변환
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
		
		System.out.println("\n채굴 성공!!! : "+ hash);
	}
}