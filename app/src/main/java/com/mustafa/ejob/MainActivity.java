package com.mustafa.ejob;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private Button gotoSignupButton;
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.login_username);
        passwordEditText = findViewById(R.id.login_password);
        submitButton = findViewById(R.id.login_submit_btn);
        gotoSignupButton = findViewById(R.id.login_goto_signup_btn);
        progressBar = findViewById(R.id.login_progress);

        submitButton.setOnClickListener(v -> sendLoginApiRequest());

        gotoSignupButton.setOnClickListener(v -> openSignupActivity());
    }

    private void sendLoginApiRequest() {
        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/login.php")
                .addBodyParameter("username", userNameEditText.getText().toString())
                .addBodyParameter("password", passwordEditText.getText().toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressBar.setVisibility(View.GONE);
                        // {"userid":"0","fullname":"0","experyears":"0","msg":"user not found.","logflag":"0","logtype":"0"}
                        //{"userid":"20","fullname":"company 1","experyears":"0","msg":"Success Login","logflag":"1","logtype":"0"}
                        //{"userid":"10","fullname":"muhammed","experyears":"5","msg":"Success Login","logflag":"1","logtype":"1"}
                        Log.v("responseJson", response.toString());
                        try {
                            String msg = response.getString("msg");
                            Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();

                            if ("1".equals(response.getString("logflag"))) {

                                String userid = response.getString("userid");
                                String fullname = response.getString("fullname");
                                String experyears = response.getString("experyears");

                                if ("1".equals(response.getString("logtype"))) {
                                    openCandidateActivity(userid, fullname, experyears);
                                } else {
                                    openCompanyActivity(userid, fullname);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openCandidateActivity(String userid, String fullname, String experyears) {
        Intent intent = new Intent(this, CandidateActivity.class);
        intent.putExtra("userid", userid);
        intent.putExtra("fullname", fullname);
        intent.putExtra("experyears", experyears);
        startActivity(intent);
    }

    private void openCompanyActivity(String userid, String fullname) {
        Intent intent = new Intent(this, CompanyActivity.class);
        intent.putExtra("userid", userid);
        intent.putExtra("fullname", fullname);
        startActivity(intent);
    }

    private void openSignupActivity() {
        startActivityForResult(new Intent(this, SignUpActivity.class), 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            userNameEditText.setText(data.getStringExtra("username"));
    }
}