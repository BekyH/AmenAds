package com.example.navtrial.fetchapi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.navtrial.R;

import java.util.HashMap;
import java.util.Map;

public class RequestQueueService {
    private static RequestQueueService mInstance;
    private RequestQueue mRequestQeueue;
    private static Context mcontext;
    private static Dialog mprogressDialog;
    private RequestQueueService(Context context){
        mcontext = context;
        mRequestQeueue = getRequestQueue();

    }
    public static synchronized RequestQueueService getInstance(Context context){
        if(mInstance==null){
            mInstance = new RequestQueueService(context);

        }
        return mInstance;
    }
    public RequestQueue getRequestQueue(){
        if(mRequestQeueue==null){

            mRequestQeueue = Volley.newRequestQueue(mcontext.getApplicationContext());

        }
        return mRequestQeueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setRetryPolicy(new DefaultRetryPolicy(5000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);

    }

    public Map<String,String> getRequestHeader(){
        Map<String,String> headerMap = new HashMap<>();
        return headerMap;
    }

    public void clearCache(){
        mRequestQeueue.getCache().clear();

    }
    public void removeCache(String key){
        mRequestQeueue.getCache().remove(key);

    }

    public static void showAlert(String message, final FragmentActivity mcontext){
        try{
            AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
            builder.setTitle("Error");
            builder.setMessage(message);
            builder.setPositiveButton("Ok",null);
            builder.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showProgressDialog(final FragmentActivity fragment){
        fragment.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mprogressDialog!=null){
                    if(mprogressDialog.isShowing()==true) cancelProgressDialog();

                }
                mprogressDialog = new Dialog(fragment);
                mprogressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                mprogressDialog.setContentView(R.layout.progress_indicator);
                mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mprogressDialog.show();
                mprogressDialog.setCancelable(false);


            }
        });
    }
    public static void cancelProgressDialog() {
        if (mprogressDialog != null){
            if (mprogressDialog.isShowing()) {
                mprogressDialog.dismiss();
            }
        }
    }


}
