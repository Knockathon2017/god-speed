package ginie.common;

import org.quartz.JobDataMap;

/**
 * Created by dhruvr on 6/8/16.
 */
public class JobUtils {
    public static <T> T getValue(JobDataMap jobDataMap, String key) {
        return (T) jobDataMap.get(key);
    }
}
