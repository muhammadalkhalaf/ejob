package com.mustafa.ejob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.mustafa.ejob.databinding.ActivitySuitableJobsBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SuitableJobsActivity extends AppCompatActivity {

    private String userid;
    private String experyears;
    private ActivitySuitableJobsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_suitable_jobs);

        userid = getIntent().getStringExtra("userid");
        experyears = getIntent().getStringExtra("experyears");

        binding.table.setMovementMethod(new ScrollingMovementMethod());

        fetchSuitableJobs();

    }

    private void fetchSuitableJobs() {
        binding.progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/showsuitablejobs.php")
                .addBodyParameter("userid", userid)
                .addBodyParameter("experyears", experyears)
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