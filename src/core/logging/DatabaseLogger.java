package core.logging;

public class DatabaseLogger implements Logger {

	@Override
	public void log() {

		System.out.println("Operation was logged to the database");

	}

}
