package p1;

public class CoupleStats {

	private float cptPrimes;
	private float cptGlobal;
	public CoupleStats(int cptPrimes, int cptGlobal) {
		super();
		this.cptPrimes = cptPrimes;
		this.cptGlobal = cptGlobal;
	}
	
	public void incrCptGlobal()
	{
		cptGlobal++;
	}
	
	public void incrCptprimes()
	{
		cptPrimes++;
	}
	
	

	public float getCptNbr() {
		return cptGlobal;
	}

	public float getCptPrimes() {
		return cptPrimes;
	}

	@Override
	public String toString() {
		return "(" + cptGlobal + ", " + cptPrimes + ")";
	}
	
	
}
