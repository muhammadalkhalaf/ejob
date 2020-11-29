package com.mustafa.ejob;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.mustafa.ejob.databinding.ActivityAddNewDiplomaBindingImpl;
import com.mustafa.ejob.databinding.ActivityAddNewJobBindingImpl;
import com.mustafa.ejob.databinding.ActivityCandidateBindingImpl;
import com.mustafa.ejob.databinding.ActivityCompanyBindingImpl;
import com.mustafa.ejob.databinding.ActivitySignUpBindingImpl;
import com.mustafa.ejob.databinding.ActivitySuitableCandidatesBindingImpl;
import com.mustafa.ejob.databinding.ActivitySuitableJobsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDNEWDIPLOMA = 1;

  private static final int LAYOUT_ACTIVITYADDNEWJOB = 2;

  private static final int LAYOUT_ACTIVITYCANDIDATE = 3;

  private static final int LAYOUT_ACTIVITYCOMPANY = 4;

  private static final int LAYOUT_ACTIVITYSIGNUP = 5;

  private static final int LAYOUT_ACTIVITYSUITABLECANDIDATES = 6;

  private static final int LAYOUT_ACTIVITYSUITABLEJOBS = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_add_new_diploma, LAYOUT_ACTIVITYADDNEWDIPLOMA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_add_new_job, LAYOUT_ACTIVITYADDNEWJOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_candidate, LAYOUT_ACTIVITYCANDIDATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_company, LAYOUT_ACTIVITYCOMPANY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_suitable_candidates, LAYOUT_ACTIVITYSUITABLECANDIDATES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mustafa.ejob.R.layout.activity_suitable_jobs, LAYOUT_ACTIVITYSUITABLEJOBS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDNEWDIPLOMA: {
          if ("layout/activity_add_new_diploma_0".equals(tag)) {
            return new ActivityAddNewDiplomaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_new_diploma is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYADDNEWJOB: {
          if ("layout/activity_add_new_job_0".equals(tag)) {
            return new ActivityAddNewJobBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_new_job is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCANDIDATE: {
          if ("layout/activity_candidate_0".equals(tag)) {
            return new ActivityCandidateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_candidate is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCOMPANY: {
          if ("layout/activity_company_0".equals(tag)) {
            return new ActivityCompanyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_company is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUITABLECANDIDATES: {
          if ("layout/activity_suitable_candidates_0".equals(tag)) {
            return new ActivitySuitableCandidatesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_suitable_candidates is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUITABLEJOBS: {
          if ("layout/activity_suitable_jobs_0".equals(tag)) {
            return new ActivitySuitableJobsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_suitable_jobs is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_add_new_diploma_0", com.mustafa.ejob.R.layout.activity_add_new_diploma);
      sKeys.put("layout/activity_add_new_job_0", com.mustafa.ejob.R.layout.activity_add_new_job);
      sKeys.put("layout/activity_candidate_0", com.mustafa.ejob.R.layout.activity_candidate);
      sKeys.put("layout/activity_company_0", com.mustafa.ejob.R.layout.activity_company);
      sKeys.put("layout/activity_sign_up_0", com.mustafa.ejob.R.layout.activity_sign_up);
      sKeys.put("layout/activity_suitable_candidates_0", com.mustafa.ejob.R.layout.activity_suitable_candidates);
      sKeys.put("layout/activity_suitable_jobs_0", com.mustafa.ejob.R.layout.activity_suitable_jobs);
    }
  }
}
