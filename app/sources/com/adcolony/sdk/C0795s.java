package com.adcolony.sdk;

import com.adcolony.sdk.C0797u;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.s */
class C0795s {
    C0795s() {
    }

    /* renamed from: a */
    static int m777a(JSONObject jSONObject, String str, int i) {
        return jSONObject.optInt(str, i);
    }

    /* renamed from: a */
    static JSONArray m778a() {
        return new JSONArray();
    }

    /* renamed from: a */
    static JSONArray m779a(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return new JSONArray();
        }
    }

    /* renamed from: a */
    static JSONArray m780a(JSONArray jSONArray, String[] strArr, boolean z) {
        for (String str : strArr) {
            if (!z || !m787a(jSONArray, str)) {
                m800b(jSONArray, str);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONArray m781a(String[] strArr) {
        JSONArray a = m778a();
        for (String b : strArr) {
            m800b(a, b);
        }
        return a;
    }

    /* renamed from: a */
    static JSONObject m782a(String str, String str2) {
        String str3;
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + ": " + e.toString();
            }
            new C0797u.C0798a().mo10920a(str3).mo10922a(C0797u.f1095j);
            return new JSONObject();
        }
    }

    /* renamed from: a */
    static JSONObject m783a(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return new JSONObject();
        }
    }

    /* renamed from: a */
    static JSONObject m784a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    static void m785a(JSONArray jSONArray, Object obj) {
        jSONArray.put(obj);
    }

    /* renamed from: a */
    static void m786a(JSONArray jSONArray, boolean z) {
        jSONArray.put(z);
    }

    /* renamed from: a */
    static boolean m787a(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (m806d(jSONArray, i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m788a(JSONObject jSONObject, String str) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (str.equals(keys.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m789a(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putDouble(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m790a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putLong(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m791a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putString(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m792a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putArray(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m793a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putObject(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m794a(JSONObject jSONObject, String str, boolean z) {
        return jSONObject.optBoolean(str, z);
    }

    /* renamed from: a */
    static String[] m795a(JSONArray jSONArray) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = m806d(jSONArray, i);
        }
        return strArr;
    }

    /* renamed from: b */
    static Object m796b(JSONArray jSONArray, int i) {
        Object opt = jSONArray.opt(i);
        if (opt == null) {
            return false;
        }
        return opt;
    }

    /* renamed from: b */
    static Object m797b(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        if (opt == null) {
            return false;
        }
        return opt;
    }

    /* renamed from: b */
    static JSONObject m798b() {
        return new JSONObject();
    }

    /* renamed from: b */
    static JSONObject m799b(String str) {
        return m782a(str, (String) null);
    }

    /* renamed from: b */
    static void m800b(JSONArray jSONArray, String str) {
        jSONArray.put(str);
    }

    /* renamed from: b */
    static boolean m801b(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putInteger(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: b */
    static boolean m802b(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
            return true;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCJSON putBoolean(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: c */
    static JSONArray m803c(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        return optJSONArray == null ? new JSONArray() : optJSONArray;
    }

    /* renamed from: c */
    static JSONObject m804c(String str) {
        try {
            String sb = C0557a.m88c().mo10650k().mo10885a(str, false).toString();
            return m782a(sb, "loadObject from filepath " + str);
        } catch (IOException e) {
            new C0797u.C0798a().mo10920a("IOException in ADCJSON's loadObject: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return m798b();
        }
    }

    /* renamed from: c */
    static JSONObject m805c(JSONArray jSONArray, int i) {
        JSONObject optJSONObject = jSONArray.optJSONObject(i);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: d */
    static String m806d(JSONArray jSONArray, int i) {
        return jSONArray.optString(i);
    }

    /* renamed from: d */
    static boolean m807d(JSONObject jSONObject, String str) {
        return jSONObject.optBoolean(str);
    }

    /* renamed from: e */
    static double m808e(JSONObject jSONObject, String str) {
        return jSONObject.optDouble(str, 0.0d);
    }

    /* renamed from: e */
    static void m809e(JSONArray jSONArray, int i) {
        jSONArray.put(i);
    }

    /* renamed from: f */
    static int m810f(JSONObject jSONObject, String str) {
        return jSONObject.optInt(str);
    }

    /* renamed from: g */
    static JSONObject m811g(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: h */
    static String m812h(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }

    /* renamed from: i */
    static boolean m813i(JSONObject jSONObject, String str) {
        try {
            C0557a.m88c().mo10650k().mo10888a(str, jSONObject.toString(), false);
            return true;
        } catch (IOException e) {
            new C0797u.C0798a().mo10920a("IOException in ADCJSON's saveObject: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }
}
