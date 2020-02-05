package org.wegscd;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.IOException;
import java.io.Serializable;

@Plugin(name = "DriverStation", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class DriverStationAppender extends AbstractAppender {

    public DriverStationAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout) {
        super(name, filter, layout, false, null);
    }

    @PluginFactory
    public static DriverStationAppender createAppender(@PluginAttribute("name") String name,
                                               @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
                                               @PluginElement("Layout") Layout layout,
                                               @PluginElement("Filters") Filter filter) {
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }

        return new DriverStationAppender(name, filter, layout);
    }

    @Override
    public void append(final LogEvent event) {
        if (event.getLevel().isMoreSpecificThan(Level.ERROR)) {
            System.out.print ("ToDSE: " );
        } else if (event.getLevel().isMoreSpecificThan(Level.WARN)) {
            System.out.print ("ToDSW: " );
        } else {
            System.out.print("ToDS: ");
        }
        byte[] ba = getLayout().toByteArray(event);
        StringBuilder sb = new StringBuilder();
        for (byte b : ba) sb.append((char) b);
        System.out.print (sb.toString());
    }
}