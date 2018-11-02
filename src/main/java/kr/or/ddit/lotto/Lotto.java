package kr.or.ddit.lotto;

public class Lotto {
	private int lottoMaxNum;
	private int lottoNum;
	
	
	public Lotto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lotto(int lottoMaxNum, int lottoNum) {
		super();
		this.lottoMaxNum = lottoMaxNum;
		this.lottoNum = lottoNum;
	}

	public int[] result() {
		int[] lotto = new int[lottoNum];
		for(int i = 0; i < lottoNum; i++) {
			lotto[i] = (int)(Math.random()*lottoMaxNum+1);
			for(int j = 0; j < i; j++) {
				if(lotto[j]==lotto[i]) {
					i--;
					break;
				}
			}
		}
		return lotto;
	}
	
	public int getLottoMaxNum() {
		return lottoMaxNum;
	}
	public void setLottoMaxNum(int lottoMaxNum) {
		this.lottoMaxNum = lottoMaxNum;
	}
	public int getLottoNum() {
		return lottoNum;
	}
	public void setLottoNum(int lottoNum) {
		this.lottoNum = lottoNum;
	}
	
	
}
