package com.finosuvidhaaccount

import android.app.Activity
import android.content.Intent
import com.example.dmt_casa.HostCasaActivity
import com.facebook.react.bridge.ActivityEventListener
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = FinosuvidhaAccountModule.NAME)
class FinosuvidhaAccountModule(reactContext: ReactApplicationContext) :
  NativeFinosuvidhaAccountSpec(reactContext), ActivityEventListener {


  private var promise: Promise? = null
  private val REQUEST_CODE = 2222

  init {
    reactContext.addActivityEventListener(this)
  }


  override fun getName(): String {
    return NAME
  }

  override fun startAccount(
    encToken: String,
    lat: String,
    lng: String,
    promise: Promise
  ) {
    val currentActivity = reactApplicationContext.currentActivity
    if (currentActivity == null) {
      promise.reject("NO_ACTIVITY", "Current activity is null")
      return
    }

    this.promise = promise

    val intent = Intent(currentActivity, HostCasaActivity::class.java).apply {
      putExtra("encdata", encToken);
      putExtra("lat", lat)
      putExtra("lng", lng)
      addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    }

    currentActivity.startActivityForResult(intent, REQUEST_CODE)
  }

  override fun onActivityResult(
    activity: Activity,
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    if (requestCode == REQUEST_CODE && promise != null) {
      if (resultCode == Activity.RESULT_OK) {
        val map = Arguments.createMap().apply {
          putBoolean("status", data?.getBooleanExtra("status", false) ?: false)
          putInt("response", data?.getIntExtra("response", 0) ?: 0)
          putString("message", data?.getStringExtra("message") ?: "")
        }
        promise?.resolve(map)
      } else {
        promise?.reject("CANCELLED", "User cancelled the account opening")
      }
      promise = null
    }
  }

  override fun onNewIntent(intent: Intent) {
    TODO("Not yet implemented")
  }

  companion object {
    const val NAME = "FinosuvidhaAccount"
  }
}
