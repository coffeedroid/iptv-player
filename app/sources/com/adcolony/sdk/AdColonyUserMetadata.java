package com.adcolony.sdk;

import android.location.Location;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyUserMetadata {
    public static final String USER_EDUCATION_ASSOCIATES_DEGREE = "associates_degree";
    public static final String USER_EDUCATION_BACHELORS_DEGREE = "bachelors_degree";
    public static final String USER_EDUCATION_GRADE_SCHOOL = "grade_school";
    public static final String USER_EDUCATION_GRADUATE_DEGREE = "graduate_degree";
    public static final String USER_EDUCATION_HIGH_SCHOOL_DIPLOMA = "high_school_diploma";
    public static final String USER_EDUCATION_SOME_COLLEGE = "some_college";
    public static final String USER_EDUCATION_SOME_HIGH_SCHOOL = "some_high_school";
    public static final String USER_FEMALE = "female";
    public static final String USER_MALE = "male";
    public static final String USER_MARRIED = "married";
    public static final String USER_SINGLE = "single";

    /* renamed from: d */
    static final int f185d = 128;

    /* renamed from: a */
    JSONArray f186a = C0795s.m778a();

    /* renamed from: b */
    JSONObject f187b = C0795s.m798b();

    /* renamed from: c */
    Location f188c;

    public AdColonyUserMetadata addUserInterest(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            C0795s.m800b(this.f186a, str);
            C0795s.m792a(this.f187b, "adc_interests", this.f186a);
        }
        return this;
    }

    public AdColonyUserMetadata clearUserInterests() {
        JSONArray a = C0795s.m778a();
        this.f186a = a;
        C0795s.m792a(this.f187b, "adc_interests", a);
        return this;
    }

    public Object getMetadata(@NonNull String str) {
        return C0795s.m797b(this.f187b, str);
    }

    public int getUserAge() {
        return C0795s.m810f(this.f187b, "adc_age");
    }

    public int getUserAnnualHouseholdIncome() {
        return C0795s.m810f(this.f187b, "adc_household_income");
    }

    public String getUserEducation() {
        return C0795s.m812h(this.f187b, "adc_education");
    }

    public String getUserGender() {
        return C0795s.m812h(this.f187b, "adc_gender");
    }

    public String[] getUserInterests() {
        String[] strArr = new String[this.f186a.length()];
        for (int i = 0; i < this.f186a.length(); i++) {
            strArr[i] = C0795s.m806d(this.f186a, i);
        }
        return strArr;
    }

    public Location getUserLocation() {
        return this.f188c;
    }

    public String getUserMaritalStatus() {
        return C0795s.m812h(this.f187b, "adc_marital_status");
    }

    public String getUserZipCode() {
        return C0795s.m812h(this.f187b, "adc_zip");
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, double d) {
        if (C0717k0.m538h(str)) {
            C0795s.m789a(this.f187b, str, d);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, @NonNull String str2) {
        if (C0717k0.m538h(str2) && C0717k0.m538h(str)) {
            C0795s.m791a(this.f187b, str, str2);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(@NonNull String str, boolean z) {
        if (C0717k0.m538h(str)) {
            C0795s.m802b(this.f187b, str, z);
        }
        return this;
    }

    public AdColonyUserMetadata setUserAge(@IntRange(from = 0, mo116to = 130) int i) {
        setMetadata("adc_age", (double) i);
        return this;
    }

    public AdColonyUserMetadata setUserAnnualHouseholdIncome(@IntRange(from = 0) int i) {
        setMetadata("adc_household_income", (double) i);
        return this;
    }

    public AdColonyUserMetadata setUserEducation(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setMetadata("adc_education", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserGender(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setMetadata("adc_gender", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserLocation(@NonNull Location location) {
        this.f188c = location;
        setMetadata("adc_longitude", location.getLongitude());
        setMetadata("adc_latitude", location.getLatitude());
        setMetadata("adc_speed", (double) location.getSpeed());
        setMetadata("adc_altitude", location.getAltitude());
        setMetadata("adc_time", (double) location.getTime());
        setMetadata("adc_accuracy", (double) location.getAccuracy());
        return this;
    }

    public AdColonyUserMetadata setUserMaritalStatus(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setMetadata("adc_marital_status", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserZipCode(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setMetadata("adc_zip", str);
        }
        return this;
    }
}
