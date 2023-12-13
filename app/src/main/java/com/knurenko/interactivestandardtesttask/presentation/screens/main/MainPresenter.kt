package com.knurenko.interactivestandardtesttask.presentation.screens.main

import android.util.Log
import com.knurenko.interactivestandardtesttask.domain.repo.PointsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.SerialDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Knurenko Bogdan 12.12.2023
 */
class MainPresenter @Inject constructor(
    private val repository: PointsRepository
) : MainContract.Presenter {
    private var view: MainContract.View? = null
    private val serialDisposable by lazy { SerialDisposable() }

    override fun onAttachView(view: MainContract.View) {
        this.view = view
    }

    override fun onDetachView() {
        view = null
        if (!serialDisposable.isDisposed) serialDisposable.dispose()
    }

    override fun loadPoints(count: Int) {
        view?.showLoading()

        try {
            serialDisposable.set(
                Flowable.fromCallable {
                    repository.fetchPoints(count)
                }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { success ->
                            view?.showSuccess(success)
                        }, { error ->
                            view?.showError(error.message)
                        }
                    )
            )
        } catch (e: Exception) {
            view?.showError(e.message)
        }
    }
}