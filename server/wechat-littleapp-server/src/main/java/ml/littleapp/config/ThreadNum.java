package ml.littleapp.config;

public enum ThreadNum {
	SINGLE("single"),
	AUTO("auto");
	
	private String nThreads;
	
	private ThreadNum(String nThreads) {
		this.nThreads = nThreads;
	}

	public String getnThreads() {
		return nThreads;
	}
}
