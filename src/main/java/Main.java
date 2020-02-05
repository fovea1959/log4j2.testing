import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        logger.warn ("Start");
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
