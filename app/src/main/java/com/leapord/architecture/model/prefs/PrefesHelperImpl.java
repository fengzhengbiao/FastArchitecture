package com.leapord.architecture.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.leapord.architecture.app.App;

import javax.inject.Inject;

/**
 * 吐司工具类
 */

public class PrefesHelperImpl implements PreferencesHelper{
    private static final String TAG = PrefesHelperImpl.class.getSimpleName();
    private static SharedPreferences sharedPreferences;

    @Inject
    public PrefesHelperImpl() {
        sharedPreferences = App.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public static void putInt(String key, int value) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public static int getInt(String key, int dValue) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.getInt(key, dValue);
    }

    public static void putLong(String key, long value) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public static long getLong(String key, Long dValue) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.getLong(key, dValue);
    }

    public static void putFloat(String key, float value) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public static Float getFloat(String key, Float dValue) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.getFloat(key, dValue);
    }

    public static void putBoolean(String key, boolean value) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static Boolean getBoolean(String key, boolean dValue) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.getBoolean(key, dValue);
    }

    public static void putString(String key, String value) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static String getString(String key, String dValue) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.getString(key, dValue);
    }

    public static void remove(String key) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        if (isExist(key)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(key);
            editor.apply();
        }
    }

    public static void clear() {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static boolean isExist(String key) {
        if (sharedPreferences == null) {
            throw new RuntimeException("You should call init() after use PrefesHelperImpl");
        }
        return sharedPreferences.contains(key);
    }
}