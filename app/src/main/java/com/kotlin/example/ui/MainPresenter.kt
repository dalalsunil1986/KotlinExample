package com.kotlin.example.ui

import com.kotlin.example.ui.base.MvpPresenter
import com.kotlin.example.ui.base.MvpView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**
 * The Presenter that will present the Post view.
 * @param postView the Post view to be presented by the presenter
 * @property postApi the API interface implementation
 * @property subscription the subscription to the API call
 */
interface MainPresenter<V : MvpView> : MvpPresenter<V>{
    fun loadPost()
}