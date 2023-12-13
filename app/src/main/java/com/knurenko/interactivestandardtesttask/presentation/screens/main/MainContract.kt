package com.knurenko.interactivestandardtesttask.presentation.screens.main

import com.knurenko.interactivestandardtesttask.domain.model.PointModel

/**
 * @author Knurenko Bogdan 12.12.2023
 */
interface MainContract {
    interface View {
        fun showLoading()
        fun showError(message: String?)
        fun showSuccess(points: List<PointModel>)
    }

    interface Presenter {
        fun onAttachView(view: View)
        fun onDetachView()
        fun loadPoints(count: Int)
    }
}