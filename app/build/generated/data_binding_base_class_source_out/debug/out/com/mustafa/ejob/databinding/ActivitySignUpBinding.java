// Generated by data binding compiler. Do not edit!
package com.mustafa.ejob.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mustafa.ejob.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySignUpBinding extends ViewDataBinding {
  @NonNull
  public final RadioButton signupCandidate;

  @NonNull
  public final RadioButton signupCompany;

  @NonNull
  public final EditText signupExperienceYears;

  @NonNull
  public final EditText signupFullname;

  @NonNull
  public final EditText signupPassword;

  @NonNull
  public final EditText signupPhoneNumber;

  @NonNull
  public final LinearLayout signupProgress;

  @NonNull
  public final RadioGroup signupRadioGroup;

  @NonNull
  public final Button signupSubmitBtn;

  @NonNull
  public final EditText signupUsername;

  protected ActivitySignUpBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RadioButton signupCandidate, RadioButton signupCompany, EditText signupExperienceYears,
      EditText signupFullname, EditText signupPassword, EditText signupPhoneNumber,
      LinearLayout signupProgress, RadioGroup signupRadioGroup, Button signupSubmitBtn,
      EditText signupUsername) {
    super(_bindingComponent, _root, _localFieldCount);
    this.signupCandidate = signupCandidate;
    this.signupCompany = signupCompany;
    this.signupExperienceYears = signupExperienceYears;
    this.signupFullname = signupFullname;
    this.signupPassword = signupPassword;
    this.signupPhoneNumber = signupPhoneNumber;
    this.signupProgress = signupProgress;
    this.signupRadioGroup = signupRadioGroup;
    this.signupSubmitBtn = signupSubmitBtn;
    this.signupUsername = signupUsername;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, R.layout.activity_sign_up, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, R.layout.activity_sign_up, null, false, component);
  }

  public static ActivitySignUpBinding bind(@NonNull View view) {
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
  public static ActivitySignUpBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySignUpBinding)bind(component, view, R.layout.activity_sign_up);
  }
}
