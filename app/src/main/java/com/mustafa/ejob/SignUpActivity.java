package com.mustafa.ejob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.mustafa.ejob.databinding.ActivitySignUpBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    boolean isCompany = false;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        binding.signupSubmitBtn.setOnClickListener(v -> sendSignupApiRequest());

        binding.signupRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.signup_candidate:
                    binding.signupExperienceYears.setVisibility(View.VISIBLE);
                    isCompany = false;
                    break;
                case R.id.signup_company:
                    binding.signupExperienceYears.setVisibility(View.GONE);
                    isCompany = true;
                    break;
            }
        });
    }

    private void sendSignupApiRequest() {
        binding.signupProgress.setVisibility(View.VISIBLE);
        String experyears = isCompany ? "0" : binding.signupExperienceYears.getText().toString();
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/register.php")
                .addBodyParameter("username", binding.signupUsername.getText().toString())
                .addBodyParameter("fullname", binding.signupFullname.getText().toString())
                .addBodyParameter("password", binding.signupPassword.getText().toString())
                .addBodyParameter("tel", binding.signupPhoneNumber.getText().toString())
                .addBodyParameter("experyears", experyears)
                .addBodyParameter("usertype", isCompany ? "0" : "1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        binding.signupProgress.setVisibility(View.GONE);
                        //{"reqflag":"1","msg":"Registered Successfuly"}
                        Log.v("responseJson", response.toString());
                        try {
                            String msg = response.getString("msg");
                            Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
                            if ("1".equals(response.getString("reqflag"))) {
                                Intent returnIntent = new Intent();
                                returnIntent.putExtra("username", binding.signupUsername.getText().toString());
                                setResult(Activity.RESULT_OK, returnIntent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        binding.signupProgress.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}