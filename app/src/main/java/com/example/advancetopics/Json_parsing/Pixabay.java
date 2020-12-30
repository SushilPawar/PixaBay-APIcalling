package com.example.advancetopics.Json_parsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.VoiceInteractor;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.advancetopics.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class  Pixabay extends AppCompatActivity {
    private RecyclerView prview;
    private ArrayList<Pixabay_model> arraylist;
    private Pixabay_adapter adapter;
    private RequestQueue mrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixabay);

        prview = findViewById(R.id.prview);
        prview.setLayoutManager(new LinearLayoutManager(this));
        arraylist = new ArrayList<>();
        mrequest = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON()
    {
        String url = "https://pixabay.com/api/?key=19696520-31d06cbe7fc1147a4e2074202&q=yellow+flowers&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("hits");
                    for(int i = 0;i<array.length();i++)
                    {
                        JSONObject hit = array.getJSONObject(i);
                        String creator = hit.getString("user");
                        String imageurl = hit.getString("webformatURL");
                        int likes = hit.getInt("likes");
                        arraylist.add(new Pixabay_model(imageurl,creator,likes));
                    }
                    adapter = new Pixabay_adapter(Pixabay.this,arraylist);
                    prview.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mrequest.add(request);
    }
}