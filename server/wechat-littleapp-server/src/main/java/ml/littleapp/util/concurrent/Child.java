package ml.littleapp.util.concurrent;

public class Child extends Patient {

	public Child() {
		System.out.println("child constructor exec");
	}

	public Child(String arg) {
		System.out.println("child arg constructor exec");
	}

	{
		System.out.println("child constructor code block exec");
	}

	static {
		System.out.println("child static code block exec");
	}
	
	public static void main(String[] args) {
		new Child("a");
		
		// 1. patient static code block exec
		// 2. child static code block exec
		// 3. patient constructor code block exec
		// 4. patient constructor exec
		// 5. child constructor code block exec
		// 6. child arg constructor exe
	}
}
