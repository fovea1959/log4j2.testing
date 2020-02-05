import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        // System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        for (int i = 0; i < 10; i++) {
            logger.info("hi bob {}", i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
        }
        for (int i = 0; i < 10; i++) {
            logger.info("spam");
        }
    }
}
