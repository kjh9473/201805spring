package kr.or.ddit.lotto;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.lotto.Lotto;

public class LottoTest {

	@Test
	public void lottoTest() {
		/***Given***/
		Lotto lotto = new Lotto();
		/***When***/
		lotto.setLottoMaxNum(45);
		lotto.setLottoNum(5);
		
		int[] result = lotto.result();
		/***Then***/
		assertEquals(5,result.length);
	}

}
