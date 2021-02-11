package com.example.herexamenmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ItemAdapter Adapter;
    ArrayList<Projects> projectList = new ArrayList<>();

    String url = "https://www.cms.baileylievens.be/api/portfolio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView testRecycler = findViewById(R.id.recycler);
        Adapter = new ItemAdapter(this, projectList);
        testRecycler.setAdapter(Adapter);
        testRecycler.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++) {
                    try {
                        JSONObject project_Info = response.getJSONObject(i);

                        Projects project = new Projects();

                        String title = project_Info.getString("title");
                        project.setTitle(title);

                        String description = project_Info.getString("body");
                        project.setDescription(description);

                        String url = project_Info.getString("view_node");
                        project.setUrl(url);

                        projectList.add(project);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                    Adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("json","Failed to get a json connection");
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
}