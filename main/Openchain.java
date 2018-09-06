package com.openchain.simple.main;
import java.util.ArrayList;
import com.openchain.simple.core.Block;


// 블록체인 구현 순서
// 1. difficulty 갯수에 따라 target을 생성
// 2. target은 difficulty의 숫자만큼 0으로 구성한다.
// 3. 블록해쉬는 [이전해쉬 + 시간 + nonce + 데이터] 조합으로 해쉬로 변환
// 4. 변환된 hash가 target과 동일한 값으로 시작하면 채택.
// 5. 동일하지않으면 nonce를 증가 시키고 반복.

public class Openchain {
	//blockchain ArrayList
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 2;
	
	public static void main(String[] arg) {
		//초기블럭 만듬
		blockchain.add(new Block("Gddong block","0"));		//데이터 , 이전 해쉬 초기값 = 0으로 시작
		System.out.println("\nGddong 블록 채굴을 시작합니다!");
		blockchain.get(0).mineBlock(difficulty);
		
		
		//블럭 생성
		for(int i=1; i<10; i++) {
			blockchain.add(new Block("block" + i, blockchain.get(blockchain.size()-1).hash)); // "block",이전 해쉬값 가져옴
			blockchain.get(i).mineBlock(difficulty);
		}
		
		//전체 블럭을 출력
	}
}
