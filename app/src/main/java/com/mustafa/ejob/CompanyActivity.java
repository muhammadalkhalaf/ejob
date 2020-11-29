package com.mustafa.ejob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonObject;
import com.mustafa.ejob.databinding.ActivityCompanyBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class CompanyActivity extends AppCompatActivity {

    private ActivityCompanyBinding binding;
    private String userid;
    private String fullname;
    private JobListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_company);

        userid = getIntent().getStringExtra("userid");
        fullname = getIntent().getStringExtra("fullname");

        binding.helloCompanyName.setText("Hello "+fullname+" !");

        adapter = new JobListAdapter(new JobListAdapter.JobDiff(),this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        fetchCompany();
    }

    private void fetchCompany() {
        binding.progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/company.php")
                .addBodyParameter("userid", userid)
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
                            JSONArray jsonArray = response.getJSONArray("jobs");
                            List<JSONObject> jsonObjectList = new ArrayList<>();
                            for (int i = 0 ; i<jsonArray.length();i++)
                                jsonObjectList.add(jsonArray.getJSONObject(i));

                            adapter.submitList(jsonObjectList);

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

    public void addNewJob(View view) {
        Intent intent = new Intent(this, AddNewJobActivity.class);
        intent.putExtra("userid", userid);
        startActivity(intent);
    }

    public void showSuitableCandidatesActivity(String reqlev, String reqexp) {
        Intent intent = new Intent(this,SuitableCandidatesActivity.class);
        intent.putExtra("reqlev",reqlev);
        intent.putExtra("reqexp",reqexp);
        startActivity(intent);
    }
}


class JobListAdapter extends ListAdapter<JSONObject, JobListAdapter.JobViewHolder> {

    private CompanyActivity companyActivity;

    public JobListAdapter(@NonNull DiffUtil.ItemCallback<JSONObject> diffCallback, CompanyActivity companyActivity) {
        super(diffCallback);
        this.companyActivity = companyActivity;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_job_item, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        JSONObject job = getItem(position);
        StringBuilder s = new StringBuilder();
        try {
            String title = job.getString("title");
            String salary = job.getString("salary");
            String reqlev = job.getString("reqlev");
            String reqexp = job.getString("reqexp");
            s.append("Title: ").append(title).append("\n");
            s.append("Salary: ").append(salary).append("\n");
            s.append("Req. Education Level: ").append(reqlev).append("\n");
            s.append("Req. Experience Years: ").append(reqexp);
            holder.jobItemView.setText(s);
            holder.showSuitableCandidates.setOnClickListener(v -> companyActivity.showSuitableCandidatesActivity(reqlev,reqexp));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static class JobViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobItemView;
        private final Button showSuitableCandidates;

        private JobViewHolder(View itemView) {
            super(itemView);
            jobItemView = itemView.findViewById(R.id.job_detail);
            showSuitableCandidates = itemView.findViewById(R.id.ShowSuitableCandidates);
        }
    }

    static class JobDiff extends DiffUtil.ItemCallback<JSONObject> {

        @Override
        public boolean areItemsTheSame(@NonNull JSONObject oldItem, @NonNull JSONObject newItem) {
            return oldItem == newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull JSONObject oldItem, @NonNull JSONObject newItem) {
            return oldItem == newItem;
        }
    }
}
