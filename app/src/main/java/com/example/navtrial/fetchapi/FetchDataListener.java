package com.example.navtrial.fetchapi;

import org.json.JSONObject;

public interface FetchDataListener {

    void onFetchCompelete(JSONObject data);
    void onFetchFailure(String msg);
    void onFetchStart();


}
