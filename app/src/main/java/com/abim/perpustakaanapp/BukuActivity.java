package com.abim.perpustakaanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BukuActivity extends AppCompatActivity {
    List<Buku> bukus;
    Context ctx;
    RequestQueue queue;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        ctx = this;
        rv = findViewById(R.id.rv);
        queue = Volley.newRequestQueue(ctx);
        bukus = new ArrayList<>();
    }

    void getBuku(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, MyReq.getBukuURL(), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject obj = response.getJSONObject(i);
                        bukus.add(new Buku(obj.getInt("harga"), obj.getInt("stok"), obj.getString("kode_buku"), obj.getString("kode_lokasi"), obj.getString("kategori"), obj.getString("judul"), obj.getString("penerbit"), obj.getString("deskripsi"), obj.getString("penulis")));

                    }
                }catch (JSONException ex){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}