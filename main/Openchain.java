package com.openchain.simple.main;
import java.util.ArrayList;
import com.openchain.simple.core.Block;


// ���ü�� ���� ����
// 1. difficulty ������ ���� target�� ����
// 2. target�� difficulty�� ���ڸ�ŭ 0���� �����Ѵ�.
// 3. ����ؽ��� [�����ؽ� + �ð� + nonce + ������] �������� �ؽ��� ��ȯ
// 4. ��ȯ�� hash�� target�� ������ ������ �����ϸ� ä��.
// 5. �������������� nonce�� ���� ��Ű�� �ݺ�.

public class Openchain {
	//blockchain ArrayList
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 2;
	
	public static void main(String[] arg) {
		//�ʱ�� ����
		blockchain.add(new Block("Gddong block","0"));		//������ , ���� �ؽ� �ʱⰪ = 0���� ����
		System.out.println("\nGddong ��� ä���� �����մϴ�!");
		blockchain.get(0).mineBlock(difficulty);
		
		
		//�� ����
		for(int i=1; i<10; i++) {
			blockchain.add(new Block("block" + i, blockchain.get(blockchain.size()-1).hash)); // "block",���� �ؽ��� ������
			blockchain.get(i).mineBlock(difficulty);
		}
		
		//��ü ���� ���
	}
}
