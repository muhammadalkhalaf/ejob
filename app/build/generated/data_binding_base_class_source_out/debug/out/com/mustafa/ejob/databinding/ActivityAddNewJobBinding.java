// Generated by data binding compiler. Do not edit!
package com.mustafa.ejob.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mustafa.ejob.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAddNewJobBinding extends ViewDataBinding {
  @NonNull
  public final Button addNewJob;

  @NonNull
  public final LinearLayout progressBar;

  @NonNull
  public final EditText reqiuredExper;

  @NonNull
  public final EditText salary;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final EditText title;

  protected ActivityAddNewJobBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button addNewJob, LinearLayout progressBar, EditText reqiuredExper, EditText salary,
      Spinner spinner, EditText title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addNewJob = addNewJob;
    this.progressBar = progressBar;
    this.reqiuredExper = reqiuredExper;
    this.salary = salary;
    this.spinner = spinner;
    this.title = title;
  }

  @NonNull
  public static ActivityAddNewJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_add_new_job, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAddNewJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAddNewJobBinding>inflateInternal(inflater, R.layout.activity_add_new_job, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAddNewJobBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_add_new_job, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAddNewJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAddNewJobBinding>inflateInternal(inflater, R.layout.activity_add_new_job, null, false, component);
  }

  public static ActivityAddNewJobBinding bind(@NonNull View view) {
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
  public static ActivityAddNewJobBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAddNewJobBinding)bind(component, view, R.layout.activity_add_new_job);
  }
}
