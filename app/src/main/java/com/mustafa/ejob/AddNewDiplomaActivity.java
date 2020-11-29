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
import com.mustafa.ejob.databinding.ActivityAddNewDiplomaBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class AddNewDiplomaActivity extends AppCompatActivity {

    private ActivityAddNewDiplomaBinding binding;
    private String userid;
    private String diplomaType;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_diploma);

        userid = getIntent().getStringExtra("userid");

        binding.RadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.add_highSchool:
                    setDiplomaType("highSchool");
                    break;
                case R.id.add_gratuated:
                    setDiplomaType("gratuated");
                    break;
                case R.id.add_master:
                    setDiplomaType("master");
                    break;
                case R.id.add_phd:
                    setDiplomaType("phd");
                    break;
            }
        });
    }

    public void addNewDiploma(View view) {
        binding.progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/addnewdiploma.php")
                .addBodyParameter("userid", userid)
                .addBodyParameter("diplomaname", diplomaType)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        binding.progressBar.setVisibility(View.GONE);
                        Log.v("responseJson", response.toString());
                        try {
                            String msg = response.getString("msg");
                            Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        binding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void setDiplomaType(String diplomaType) {
        this.diplomaType = diplomaType;
    }
}