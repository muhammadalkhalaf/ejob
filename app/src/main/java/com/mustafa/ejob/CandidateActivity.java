package com.mustafa.ejob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.mustafa.ejob.databinding.ActivityCandidateBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CandidateActivity extends AppCompatActivity {

    private ActivityCandidateBinding binding;
    private String userid;
    private String fullname;
    private String experyears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_candidate);

        userid = getIntent().getStringExtra("userid");
        fullname = getIntent().getStringExtra("fullname");
        experyears = getIntent().getStringExtra("experyears");

        binding.helloUsername.setText("Hello "+fullname+" !");
        binding.table.setMovementMethod(new ScrollingMovementMethod());

        String[] paths = {"Random Sort", "Sort by Experience years", "Sort by Education Level"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fetchUser(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.addNewDiploma.setOnClickListener(v -> openAddNewDiplomaActivity());
        binding.showSuitableJobs.setOnClickListener(v -> openSuitableJobsActivity());

    }

    private void openSuitableJobsActivity() {
        Intent intent = new Intent(this, SuitableJobsActivity.class);
        intent.putExtra("userid", userid);
        intent.putExtra("experyears", experyears);
        startActivity(intent);
    }

    private void openAddNewDiplomaActivity() {
        Intent intent = new Intent(this, AddNewDiplomaActivity.class);
        intent.putExtra("userid", userid);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fetchUser(0);
    }

    private void fetchUser(int sortby) {
        binding.progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/user.php")
                .addBodyParameter("userid", userid)
                .addBodyParameter("fullname", fullname)
                .addBodyParameter("experyears", experyears)
                .addBodyParameter("sortby", String.valueOf(sortby))
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        binding.progressBar.setVisibility(View.GONE);
                        Log.v("responseJson", response.toString());
                        try {
                            String msg = response.getString("msg");
                            binding.message.setText(msg);

                            showJobs(response.getJSONArray("jobs"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        finish();
                        binding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void showJobs(JSONArray jobs) throws JSONException {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < jobs.length(); i++) {
            JSONObject job = jobs.getJSONObject(i);
            s.append("Title: ").append(job.getString("title")).append("\n");
            s.append("Salary: ").append(job.getString("salary")).append("\n");
            s.append("Company Name: ").append(job.getString("companyname")).append("\n");
            s.append("Company Tel: ").append(job.getString("companytel")).append("\n");
            s.append("Req. Education Level: ").append(job.getString("reqlev")).append("\n");
            s.append("Req. Experience Years: ").append(job.getString("reqexp")).append("\n");
            s.append("------------------------\n");
        }

        binding.table.setText(s.toString());
    }
}