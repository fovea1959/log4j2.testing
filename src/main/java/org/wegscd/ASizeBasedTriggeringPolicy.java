package org.wegscd;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.*;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

// https://stackoverflow.com/questions/31670088/how-to-add-the-date-timestamp-to-log4j2-logfiles

@Plugin(name = "ASizeBasedTriggeringPolicy", category = Core.CATEGORY_NAME, printObject = true)
public class ASizeBasedTriggeringPolicy extends AbstractTriggeringPolicy {
    private SizeBasedTriggeringPolicy sizeBasedTriggeringPolicy;
    private RollingFileManager aManager;

    protected ASizeBasedTriggeringPolicy(String maxFileSize) {
        sizeBasedTriggeringPolicy = SizeBasedTriggeringPolicy.createPolicy(maxFileSize);
    }

    public void initialize(RollingFileManager aManager) {
        sizeBasedTriggeringPolicy.initialize(aManager);
        this.aManager = aManager;
    }

    public boolean isTriggeringEvent(LogEvent event) {
        if (sizeBasedTriggeringPolicy.isTriggeringEvent(event)) {
            aManager.getPatternProcessor().setPrevFileTime(System.currentTimeMillis());
            return true;
        } else {
            return false;
        }
    }

    @PluginFactory
    public static ASizeBasedTriggeringPolicy createPolicy(@PluginAttribute("size") String size) {
        return new ASizeBasedTriggeringPolicy(size);
    }
}