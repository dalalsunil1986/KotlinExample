package com.kotlin.example.ui.base

import android.app.Dialog
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlin.example.utils.CommonUtils



open class BaseActivity : AppCompatActivity(), MvpView {

    private var progressDialog: Dialog? = null

    fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    private fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showLoading() {
        hideLoading()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        if (progressDialog != null && progressDialog!!.isShowing()) {
            progressDialog!!.cancel()
        }
    }

    fun showMessage(message: String) {
        if (message != null)
            displayMessage(message)
    }

    fun showError(message: String) {
        if (message != null)
            displayError(message)
    }

}