package ginie.common;

import com.google.common.base.Preconditions;
import ginie.GinieException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public class NullUtils {

    public static void checkNotBlank(String... inputs) throws GinieException {
        Preconditions.checkNotNull(inputs, new GinieException("input array is null"));
        for (String input : inputs) {
            if (StringUtils.isBlank(input)) {
                throw new GinieException("String input [" + inputs + "] contains null, empty or blank");
            }
        }
    }


    public static void checkNotEmpty(List... lists) throws GinieException {
        Preconditions.checkNotNull(lists, new GinieException("input array list is null"));
        for (List list : lists) {
             if(list == null || list.size() == 0){
                 throw new GinieException("List input [" + list + "] contains null, empty or blank");
             }
        }
    }
}
