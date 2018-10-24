package com.kotlin.example.ui

import com.kotlin.example.data.Config
import com.kotlin.example.data.DataManager
import com.kotlin.example.ui.base.BasePresenter
import com.kotlin.example.ui.base.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**
 * The Presenter that will present the Post view.
 * @param postView the Post view to be presented by the presenter
 * @property postApi the API interface implementation
 * @property subscription the subscription to the API call
 */
class MyPresenter<V : MainView> @Inject constructor(
        private val dataManager: DataManager,
        private val compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, compositeDisposable), MainPresenter<V> {


    /**
     * Loads the posts from the API and presents them in the view when retrieved, or showss error if
     * any.
     */
    override fun loadPost() {
        compositeDisposable.addAll(
                        dataManager.getAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ recipes ->
                            if (!isViewAttached())
                                return@subscribe
                            mvpView?.hideLoading()
                            if (recipes != null) {
                                mvpView?.updatePosts(recipes!!)

                            }
                        }, { throwable ->
                            if (!isViewAttached())
                                return@subscribe
                            mvpView?.hideLoading()

                        })
        )
    }


}