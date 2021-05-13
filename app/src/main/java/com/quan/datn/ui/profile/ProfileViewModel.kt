package com.quan.datn.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.quan.datn.model.ProfileModel
import com.quan.datn.model.UpdateInfoRequest
import com.quan.datn.model.remote.ApiHelp
import com.quan.datn.model.repository.BenhNhanRepository
import com.quan.datn.ui.utils.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class ProfileViewModel : ViewModel() {

    val userProfile = MutableLiveData<ProfileModel>()

    private val repository: BenhNhanRepository =
        ApiHelp.createRetrofit().create(BenhNhanRepository::class.java)

    @SuppressLint("CheckResult")
    fun updateFile(updateInfoRequest: UpdateInfoRequest, pathFile:String) {
        val file = File(pathFile)
        val requestFile: RequestBody =
            RequestBody.create("*/*".toMediaTypeOrNull(), file)
        val body: MultipartBody.Part =
            MultipartBody.Part.createFormData("avatar", avtar, requestFile)
        repository.updateInfo(body, item.fileType!!).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                fileResponse.value = it
            }, {
                it.printStackTrace()
            })
    }


}