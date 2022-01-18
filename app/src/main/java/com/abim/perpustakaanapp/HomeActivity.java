package com.abim.perpustakaanapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    RequestQueue queue;
    Context ctx;
    EditText et_user, et_pass;
    Button btn;
    Session s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        ctx = this;
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        btn = findViewById(R.id.btn_login);
        queue = Volley.newRequestQueue(ctx);

        s = new Session(ctx);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_pass.getText().toString().equalsIgnoreCase("") || et_user.getText().toString().equalsIgnoreCase("")){
                    AlertDialog dialog = new AlertDialog.Builder(ctx).create();
                    dialog.setMessage("Semua Field Harus Diisi");
                    dialog.setTitle("Eror");
                    dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
                else {
                    String user, pass;
                    user = et_user.getText().toString();
                    pass = et_pass.getText().toString();

                    StringRequest request = new StringRequest(Request.Method.POST, MyReq.getLoginURL(), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
                                s.setUser(object.getInt("id_user"), object.getString("name"), object.getString("username"));

                                Intent intent = new Intent(HomeActivity.this, DashboardActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception ex) {
                                AlertDialog dialog = new AlertDialog.Builder(ctx).create();
                                dialog.setTitle("Eror");
                                dialog.setMessage("Tidak dapat menemukan pengguna!");
                                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("username", user);
                            params.put("password", pass);
                            return params;
                        }
                    };

                    queue.add(request);
                }
            }
        });
    }
}