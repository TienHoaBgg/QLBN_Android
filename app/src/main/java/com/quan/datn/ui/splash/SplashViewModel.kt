package com.quan.datn.ui.splash

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.quan.datn.model.remote.ApiHelp
import com.quan.datn.model.repository.BenhNhanRepository
import com.quan.datn.ui.utils.DataManager
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SplashViewModel : ViewModel() {

    val isLoading = MutableLiveData(false)
    var callBack:SplashCallBack? = null

    private val repository: BenhNhanRepository =
        ApiHelp.createRetrofit().create(BenhNhanRepository::class.java)

    fun getInfoBenhNhan(content: Context): Disposable {
        return repository.getInfo(DataManager.getPhoneLogin(content))
            .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.status == 200 && it.data != null) {
                        Observable.create((ObservableOnSubscribe<Boolean> { _ ->
                            DataManager.saveSessionLogin(content, it.data!!)
                        })).subscribeOn(Schedulers.newThread()).subscribe()
                        callBack?.success()
                    } else {
                        callBack?.error(it.message)
                    }
                }, {
                    it.printStackTrace()
                    callBack?.error(it.localizedMessage)
                }
            )
    }

}