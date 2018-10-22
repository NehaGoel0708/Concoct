package com.example.khimu.concoct;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

EditText lemail,lpassword;
Button loginbtn;
String email,password;
String login_url="http://10.1.2.85/concoct/login.php";

AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
builder=new AlertDialog.Builder(LoginActivity.this);
 loginbtn=(Button) findViewById(R.id.submitbtn);
 lemail=(EditText) findViewById(R.id.email);
 lpassword=(EditText) findViewById(R.id.password);
 loginbtn.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         email=lemail.getText().toString();
         password=lpassword.getText().toString();
         if(email.equals("")||password.equals("")){
             builder.setTitle("Something went wrong");
             displayAlert("Enter the valid credentials...");
         }
         else{
             StringRequest stringRequest=new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                 @Override
                 public void onResponse(String response) {
                     try{
                         JSONArray jsonArray=new JSONArray(response);
                         JSONObject jsonObject=jsonArray.getJSONObject(0);
                         String code=jsonObject.getString("code");
                         if(code.equals("Login Failed...")){

                             builder.setTitle("Server response");
                            displayAlert(jsonObject.getString("message"));
                         }
                         else{
                             Intent startdash=new Intent(LoginActivity.this,DashboardActivity.class);
                             startActivity(startdash);

                         }
                         displayAlert(code);
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                 }
             }){
                 @Override
                 protected Map<String, String> getParams() throws AuthFailureError {
                     Map<String, String> params=new HashMap<String, String>();
                     params.put("email",email);
                     params.put("password",password);
                     return params;
                 }
             };
             MySingleton.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);
         }
     }
 });
    }
    public void displayAlert(String message){
        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lemail.setText("");
                lpassword.setText("");
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}