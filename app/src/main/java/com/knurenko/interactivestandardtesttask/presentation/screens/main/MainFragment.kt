package com.knurenko.interactivestandardtesttask.presentation.screens.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.knurenko.interactivestandardtesttask.R
import com.knurenko.interactivestandardtesttask.di.AppEntryPoint
import com.knurenko.interactivestandardtesttask.domain.model.PointModel
import com.knurenko.interactivestandardtesttask.presentation.screens.points.ChartFragment
import javax.inject.Inject

/**
 * @author Knurenko Bogdan 13.12.2023
 */
class MainFragment : Fragment(), MainContract.View {

    private lateinit var fetchButton: Button
    private lateinit var pointsCountEditText: EditText
    private lateinit var progressBar: ProgressBar

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun showLoading() {
        fetchButton.isEnabled = false
        progressBar.visibility = View.VISIBLE
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        fetchButton.isEnabled = true
        progressBar.visibility = View.INVISIBLE
    }

    override fun showSuccess(points: List<PointModel>) {
        fetchButton.isEnabled = true
        progressBar.visibility = View.INVISIBLE

        findNavController().navigate(R.id.action_mainFragment_to_chartFragment, ChartFragment.savePointsToBundle(points))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false).apply {
            progressBar = findViewById(R.id.progress_bar)
            progressBar.visibility = View.INVISIBLE

            pointsCountEditText = findViewById(R.id.points_count_edit_text)

            fetchButton = findViewById(R.id.fetch_points_button)
            fetchButton.setOnClickListener {
                val pointsText = pointsCountEditText.text.toString()

                // validation
                if (pointsText.isBlank()) {
                    showError("Please provide points count")
                    return@setOnClickListener
                }
                val pointsCount = pointsText.toIntOrNull()
                if (pointsCount == null) {
                    showError("Wrong points count")
                    return@setOnClickListener
                }

                presenter.loadPoints(pointsCount)
            }

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppEntryPoint.getComponent(requireContext()).inject(this)
        presenter.onAttachView(this)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.onDetachView()
    }

}