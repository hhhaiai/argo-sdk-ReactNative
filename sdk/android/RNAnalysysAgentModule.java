package com.argo.rn;


import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;
import com.analysys.AnalysysAgent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * String -> String
 * ReadableMap -> Object
 * Boolean -> Bool
 * Integer -> Number
 * Double -> Number
 * Float -> Number
 * Callback -> function
 * ReadableArray -> Array
 */

public class RNAnalysysAgentModule extends ReactContextBaseJavaModule {

    public RNAnalysysAgentModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    private static final String MODULE_NAME = "RNAnalysysAgentModule";
    private static final String MODULE_VERSION = "4.0.6";
    private static final String LOGTAG = "analysys";

    /**
     * 返回一个字符串名字，这个名字在 JavaScript (RN)端标记这个模块。
     */
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    /**
     * ReadableMap 转换成 JSONObject
     */
    private HashMap convertToHashMap(ReadableMap properties) {
        if (properties == null) {
            return null;
        }
        ReadableNativeMap map = (ReadableNativeMap) properties;
        HashMap<String, Object> hashMap = map.toHashMap();
        return hashMap;
    }

    private ReadableNativeMap MapToReadableMap(Map properties) {
        if (properties == null) {
            return null;
        }

        Map<String, Object> hashMap = properties;
        ReadableNativeMap map = (ReadableNativeMap) hashMap;
        return map;
    }

    @ReactMethod
    public void pageView(String pageName, ReadableMap properties) {
        try {
            HashMap<String, Object> hashMap = convertToHashMap(properties);
            if(hashMap == null){
                AnalysysAgent.pageView(this.getReactApplicationContext(), pageName);
            }else{
                AnalysysAgent.pageView(this.getReactApplicationContext(), pageName, hashMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }

    }

    @ReactMethod
    public void track(String eventName, ReadableMap properties) {
        try {
            HashMap<String, Object> hashMap = convertToHashMap(properties);
            if(hashMap == null){
                AnalysysAgent.track(this.getReactApplicationContext(), eventName);
            }else{
                AnalysysAgent.track(this.getReactApplicationContext(), eventName, hashMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }
    @ReactMethod
    public void identify(String distinctId ) {
        try {
            AnalysysAgent.identify(this.getReactApplicationContext(), distinctId );

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }
    @ReactMethod
    public void alias(String aliasId ,String originalId ) {
        try {
            AnalysysAgent.alias(this.getReactApplicationContext(), aliasId ,originalId );

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }
    @ReactMethod
    public void profileSet(ReadableMap properties) {
        try {
            HashMap<String, Object> hashMap = convertToHashMap(properties);
            AnalysysAgent.profileSet(this.getReactApplicationContext(), hashMap);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }


    @ReactMethod
    public void profileSetOnce(ReadableMap properties) {
        try {
            HashMap<String, Object> hashMap = convertToHashMap(properties);
            AnalysysAgent.profileSetOnce(this.getReactApplicationContext(), hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void profileIncrement(ReadableMap properties) {
        try {
            Map<String, Number> hashMap = convertToHashMap(properties);
            AnalysysAgent.profileIncrement(this.getReactApplicationContext(),hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void profileAppend(ReadableMap properties) {
        try {
            HashMap<String, Object> hashMap = convertToHashMap(properties);
            AnalysysAgent.profileAppend(this.getReactApplicationContext(), hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void profileUnset(String profileKey) {
        try {
            AnalysysAgent.profileUnset(this.getReactApplicationContext(), profileKey);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void profileDelete() {
        try {
            AnalysysAgent.profileDelete(this.getReactApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void registerSuperProperty(String superPropertyName,String superPropertyValue) {
        try {
            AnalysysAgent.registerSuperProperty(this.getReactApplicationContext(),superPropertyName,superPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void registerSuperProperties(ReadableMap properties) {
        try {
             HashMap<String, Object> hashMap = convertToHashMap(properties);
            AnalysysAgent.registerSuperProperties(this.getReactApplicationContext(),hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void unRegisterSuperProperty(String superPropertyName) {
        try {
            AnalysysAgent.unRegisterSuperProperty(this.getReactApplicationContext(),superPropertyName);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void clearSuperProperties() {
        try {
            AnalysysAgent.clearSuperProperties(this.getReactApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void getSuperProperty(String superPropertyName,Callback callbackFn) {
        try {
            Object propertyValue = AnalysysAgent.getSuperProperty(this.getReactApplicationContext(),superPropertyName);
            if(propertyValue == null){
                callbackFn.invoke("");
            }else{
                callbackFn.invoke(propertyValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }

    @ReactMethod
    public void getSuperProperties(Callback callbackFn) {
        try {
            Map<String, Object> properties = AnalysysAgent.getSuperProperties(this.getReactApplicationContext());
            if(properties == null){
                callbackFn.invoke("");
            }else{
                callbackFn.invoke(properties.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, "获取多个参数异常: " );
        }
    }

    @ReactMethod
    public void reset() {
        try {
            AnalysysAgent.reset(this.getReactApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(LOGTAG, e.toString() + "");
        }
    }
}
