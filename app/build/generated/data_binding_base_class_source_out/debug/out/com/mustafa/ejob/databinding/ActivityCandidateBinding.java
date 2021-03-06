// Generated by data binding compiler. Do not edit!
package com.mustafa.ejob.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mustafa.ejob.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCandidateBinding extends ViewDataBinding {
  @NonNull
  public final Button addNewDiploma;

  @NonNull
  public final TextView helloUsername;

  @NonNull
  public final TextView message;

  @NonNull
  public final LinearLayout progressBar;

  @NonNull
  public final Button showSuitableJobs;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView table;

  protected ActivityCandidateBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button addNewDiploma, TextView helloUsername, TextView message, LinearLayout progressBar,
      Button showSuitableJobs, Spinner spinner, TextView table) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addNewDiploma = addNewDiploma;
    this.helloUsername = helloUsername;
    this.message = message;
    this.progressBar = progressBar;
    this.showSuitableJobs = showSuitableJobs;
    this.spinner = spinner;
    this.table = table;
  }

  @NonNull
  public static ActivityCandidateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_candidate, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCandidateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCandidateBinding>inflateInternal(inflater, R.layout.activity_candidate, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCandidateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_candidate, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCandidateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCandidateBinding>inflateInternal(inflater, R.layout.activity_candidate, null, false, component);
  }

  public static ActivityCandidateBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityCandidateBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCandidateBinding)bind(component, view, R.layout.activity_candidate);
  }
}
