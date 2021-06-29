package wseemann.media2;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class Metadata {
    public static final int BOOLEAN_VAL = 3;
    public static final int BYTE_ARRAY_VAL = 7;
    public static final int DATE_VAL = 6;
    public static final int DOUBLE_VAL = 5;
    public static final int INTEGER_VAL = 2;
    public static final int LONG_VAL = 4;
    public static final int STRING_VAL = 1;
    private HashMap<String, String> mParcel;

    private boolean checkMetadataId(String str) {
        return true;
    }

    private void checkType(String str, int i) {
        String str2 = this.mParcel.get(str);
        if (str2 == null) {
            throw new IllegalStateException("Wrong type " + i + " but got " + str2);
        }
    }

    public HashMap<String, String> getAll() {
        return this.mParcel;
    }

    public boolean getBoolean(String str) {
        checkType(str, 3);
        return Integer.valueOf(this.mParcel.get(str)).intValue() == 1;
    }

    public byte[] getByteArray(String str) {
        checkType(str, 7);
        return this.mParcel.get(str).getBytes();
    }

    public Date getDate(String str) {
        checkType(str, 6);
        long longValue = Long.valueOf(this.mParcel.get(str)).longValue();
        String str2 = this.mParcel.get(str);
        if (str2.length() == 0) {
            return new Date(longValue);
        }
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str2));
        instance.setTimeInMillis(longValue);
        return instance.getTime();
    }

    public double getDouble(String str) {
        checkType(str, 5);
        return Double.valueOf(this.mParcel.get(str)).doubleValue();
    }

    public int getInt(String str) {
        checkType(str, 2);
        return Integer.valueOf(this.mParcel.get(str)).intValue();
    }

    public long getLong(String str) {
        checkType(str, 4);
        return Long.valueOf(this.mParcel.get(str)).longValue();
    }

    public String getString(String str) {
        checkType(str, 1);
        return String.valueOf(this.mParcel.get(str));
    }

    public boolean has(String str) {
        if (checkMetadataId(str)) {
            return this.mParcel.containsKey(str);
        }
        throw new IllegalArgumentException("Invalid key: " + str);
    }

    public boolean parse(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        this.mParcel = hashMap;
        return true;
    }
}
