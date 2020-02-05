package org.wegscd;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

@Plugin(name = "TimeIsSetFilter", category = Core.CATEGORY_NAME, elementType = Filter.ELEMENT_TYPE, printObject = true)
public final class TimeIsSetFilter extends AbstractFilter {



    int i = 0;
    private TimeIsSetFilter(Result onMatch, Result onMismatch) {
        super(onMatch, onMismatch);
    }

    @Override
    public Result filter(LogEvent event) {
        Result r =  Result.NEUTRAL;
        if (++i < 10) r = Result.DENY;
        // System.out.println ("TimeIsSetFilter " + i + " " + r);
        return r;
    }

    /**
     * Create a ThresholdFilter.
     * @param onMatch The action to take on a match.
     * @param onMismatch The action to take on a mismatch.
     * @return The created ThresholdFilter.
     */
    @PluginFactory
    public static TimeIsSetFilter createFilter(@PluginAttribute(value = "onMatch", defaultString = "NEUTRAL") Result onMatch,
                                               @PluginAttribute(value = "onMismatch", defaultString= "DENY") Result onMismatch) {
        return new TimeIsSetFilter(onMatch, onMismatch);
    }}