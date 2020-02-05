
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger logger;

    public static void main(String[] args) {
        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        logger = LoggerFactory.getLogger(Main.class);

        fixupInfo(logger);
        logger.warn ("Start");

        for (int i = 0; i < 10; i++) {
            logger.info("hi bob {}", i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
        }
        for (int i = 0; i < 10; i++) {
            logger.debug("debug1");
        }
        fixupDebug(logger);
        for (int i = 0; i < 10; i++) {
            logger.debug("debug2");
        }
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    static void fixupInfo(Logger slf4jLogger) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(slf4jLogger.getName(), org.apache.logging.log4j.Level.INFO);
    }

    static void fixupDebug(Logger slf4jLogger) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(slf4jLogger.getName(), org.apache.logging.log4j.Level.DEBUG);
    }
}
