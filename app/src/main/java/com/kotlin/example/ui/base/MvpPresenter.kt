package com.kotlin.example.ui.base


interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()
}