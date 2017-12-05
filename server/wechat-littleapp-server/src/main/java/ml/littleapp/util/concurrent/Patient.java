package ml.littleapp.util.concurrent;

public class Patient {

	public Patient() {
		System.out.println("patient constructor exec");
	}

	public Patient(String arg) {
		System.out.println("patient arg constructor exec");
	}
	
	{
		System.out.println("patient constructor code block exec");
	}
	
	static {
		System.out.println("patient static code block exec");
	}
}
