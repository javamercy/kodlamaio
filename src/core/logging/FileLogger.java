package core.logging;

public class FileLogger implements Logger {

	@Override
	public void log() {

		System.out.println("Operation was logged to the file");

	}

}
