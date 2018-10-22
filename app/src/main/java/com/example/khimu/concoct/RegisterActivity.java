package com.example.khimu.concoct;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
EditText nameedt,emailedt,mobileedt,passwordedt;
Button registerbtn;
String name,email,mobile,password;
AlertDialog.Builder builder;
String register_url="http://10.1.2.85/concoct/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    nameedt=(EditText)findViewById(R.id.name);
    emailedt=(EditText)findViewById(R.id.email);
    mobileedt=(EditText) findViewById(R.id.mobile);
    passwordedt=(EditText) findViewById(R.id.password);
    registerbtn=(Button)findViewById(R.id.regbtn);

    builder= new AlertDialog.Builder(RegisterActivity.this);
    registerbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name=nameedt.getText().toString();
            email=emailedt.getText().toString();
            mobile=mobileedt.getText().toString();
            password=passwordedt.getText().toString();
            if(name.equals("")||email.equals("")||mobile.equals("")||password.equals("")){
                builder.setTitle("Error");
                builder.setMessage("kindly fill all the fields..");
                displayAlert("input error");
            }
            else{
                StringRequest stringRequest=new StringRequest(Request.Method.POST, register_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject=jsonArray.getJSONObject(0);
                            String code=jsonObject.getString("code");
                            String message=jsonObject.getString("message");
                            builder.setTitle("Server response");
                            builder.setMessage(message);
                            displayAlert(code);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                  protected Map<String,String> getParams() throws AuthFailureError{
                        Map<String, String> params=new HashMap<String, String>();
                        params.put("name",name);
                        params.put("email",email);
                        params.put("mobile",mobile);
                        params.put("password",password);
                        return params;
                  }
                };
            MySingleton.getInstance(RegisterActivity.this).addToRequestQueue(stringRequest);
            }
        }
    });
    }
    public void displayAlert(final String code){
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           if(code.equals("input error")){
               passwordedt.setText("");
           }
           else if(code.equals("registration successful")){
               finish();
           }
           else if(code.equals("Registration failed")){
               nameedt.setText("");
                emailedt.setText("");
                mobileedt.setText("");
                passwordedt.setText("");
           }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
