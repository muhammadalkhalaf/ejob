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
import com.mustafa.ejob.databinding.ActivitySuitableCandidatesBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SuitableCandidatesActivity extends AppCompatActivity {

    private String reqlev;
    private String reqexp;
    private ActivitySuitableCandidatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_suitable_candidates);

        reqlev = getIntent().getStringExtra("reqlev");
        reqexp = getIntent().getStringExtra("reqexp");

        binding.table.setMovementMethod(new ScrollingMovementMethod());

        fetchSuitableCandidates();
    }

    private void fetchSuitableCandidates() {
        binding.progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.post("http://ejob-svu.atwebpages.com/api/showsuitablecan.php")
                .addBodyParameter("reqlev", reqlev)
                .addBodyParameter("reqexp", reqexp)
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

                            showCandidates(response.getJSONArray("candidates"));

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

    private void showCandidates(JSONArray candidates) throws JSONException {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < candidates.length(); i++) {
            JSONObject candidate = candidates.getJSONObject(i);
            s.append("Name: ").append(candidate.getString("name")).append("\n");
            s.append("Phone: ").append(candidate.getString("tel")).append("\n");
            s.append("------------------------\n");
        }

        binding.table.setText(s.toString());
    }
}