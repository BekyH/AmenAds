package com.example.navtrial.fetchapi;

import android.content.Context;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class GETApiRequest {
    public void request(final Context context,final FetchDataListener listener,final String apiurl) throws JSONException{
        if(listener!=null) {
            listener.onFetchStart();
        }
            String url = apiurl;

            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (listener != null) {
                            if (response.has("response")) {
                                listener.onFetchCompelete(response);


                            } else if (response.has("error")) {
                                listener.onFetchFailure(response.getString("error"));

                            } else {
                                listener.onFetchCompelete(null);
                            }
                        }

                    } catch (JSONException ex) {
                        ex.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NoConnectionError) {
                        listener.onFetchFailure("network connectivity problem");
                    } else if (error.networkResponse != null && error.networkResponse.data != null) {
                        VolleyError volley_error = new VolleyError(new String(error.networkResponse.data));
                        String errorMessage = "";
                        try {
                            JSONObject errorJson = new JSONObject(volley_error.getMessage().toString());
                            if (errorJson.has("error")) errorMessage = errorJson.getString("error");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (errorMessage.isEmpty()) {
                            errorMessage = volley_error.getMessage();
                        }

                        if (listener != null) listener.onFetchFailure(errorMessage);
                    } else {
                        listener.onFetchFailure("Something went wrong. Please try again later");
                    }

                }

            });

        RequestQueueService.getInstance(context).addToRequestQueue(getRequest.setShouldCache(false));
    }
}
