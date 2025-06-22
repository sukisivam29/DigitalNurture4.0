package SingletonPatternExample;

public class SingletonPatternExample {

    // Singleton Logger Class
    static class Logger {
        private static Logger instance;
        private Logger() {
            System.out.println("Logger Initialized.");
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");


        if (logger1 == logger2) {
            System.out.println("Both loggers are the same instance.");
        } else {
            System.out.println("Different logger instances!");
        }
    }
}

