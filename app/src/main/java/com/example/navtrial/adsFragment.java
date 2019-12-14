package com.example.navtrial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.navtrial.data.event;
import com.example.navtrial.fetchapi.FetchDataListener;
import com.example.navtrial.fetchapi.GETApiRequest;
import com.example.navtrial.fetchapi.RequestQueueService;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class adsFragment extends Fragment {
    ProgressDialog progressDialog;
    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;
    private List<Ads> Adslist;
    private JSONArray jsonArray;
    String url = "http://192.168.17.1:3000/ads";

    public adsFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment, container, false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();
                //Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                if(response.isSuccessful()){
                    generateDatalist(response.body());
                }
                else {
                    Toast.makeText(getContext(),"response is not successfult",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<event>> call, Throwable t) {
                progressDialog.dismiss();
                if (t instanceof IOException) {

                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(getContext(), "conversion issue! big problems", Toast.LENGTH_SHORT).show();

                }
            }
        });


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                 FirebaseAuth.getInstance().signOut();
                LoginFragment lf = new LoginFragment();
                FragmentTransaction fragmentTransaction =getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers,lf)
                        .addToBackStack(null)
                        .commit();
                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.INVISIBLE);


            }
        };
        super.onCreate(savedInstanceState);


    }
    public void getdatafromapi(){

    }
    public void generateDatalist(List<event>eventList){
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
        adsRecyclerAdapter = new adsAdapter(getContext(), eventList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adsRecyclerView.setAdapter(adsRecyclerAdapter);


    }


    public void getApiData() {
        try {
            GETApiRequest getApiRequest = new GETApiRequest();
            String url = "http://10.0.2.2:3000/ads";
            getApiRequest.request(getContext(), fetchGetResultListener, url);
            Toast.makeText(getContext(), "GET API called", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    FetchDataListener fetchGetResultListener = new FetchDataListener() {
        @Override
        public void onFetchCompelete(JSONObject data) {
            RequestQueueService.cancelProgressDialog();
            try {


                if (data != null) {
                    if (data.has("success")) {
                        int success = data.getInt("success");
                        if (success == 1) {
                            JSONObject res = data.getJSONObject("response");
                            Toast.makeText(getContext(), res.toString(), Toast.LENGTH_LONG).show();


                        } else {
                            RequestQueueService.showAlert("Error! no data fetched", getActivity());

                        }

                    }

                } else {
                    RequestQueueService.showAlert("Error! no data fetched", getActivity());
                }
            } catch (Exception e) {
               // RequestQueueService.showAlert(e.getMessage(), getActivity());
                e.printStackTrace();


            }
        }

        @Override
        public void onFetchFailure(String msg) {
           RequestQueueService.cancelProgressDialog();
            RequestQueueService.showAlert(msg, getActivity());


        }

        @Override
        public void onFetchStart() {
            RequestQueueService.showProgressDialog(getActivity());
        }






        public void getAds() {
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    jsonArray = response;
                    Adslist = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject item = jsonArray.getJSONObject(i);
                            String name = item.getString("name");
                            String organizer = item.getString("organizer");
                            String location = item.getString("location");
                            String date = item.getString("date");
                            String category = item.getString("category");
                            Ads ad = new Ads(name, organizer, location, date, category);
                            Adslist.add(ad);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    refreshData();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    jsonArray = null;
                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    refreshData();
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Accept", "application/json");
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };
            requestQueue.add(req);


        }

        public void refreshData() {
//            adsRecyclerAdapter = new adsAdapter(getContext(), Adslist);
//            adsRecyclerView.setAdapter(adsRecyclerAdapter);
        }

    };


}
