package utils;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.skyscreamer.jsonassert.comparator.DefaultComparator;

public class JsonComparator extends DefaultComparator {
    private static final String DATE_FORMAT = "MM-DD-yyyy HH:mm:ss.SSS";

    public JsonComparator(JSONCompareMode mode) {
        super(mode);
    }

}
