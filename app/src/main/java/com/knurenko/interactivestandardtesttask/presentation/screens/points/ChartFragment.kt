package com.knurenko.interactivestandardtesttask.presentation.screens.points

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.Gson
import com.knurenko.interactivestandardtesttask.R
import com.knurenko.interactivestandardtesttask.domain.model.PointModel

/**
 * @author Knurenko Bogdan 13.12.2023
 */
class ChartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false).apply {

            val points = extractPoints()
            val recycler = findViewById<RecyclerView>(R.id.recycler_view)
            val adapter = PointsListAdapter(points)
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext())

            val chartView = findViewById<LineChart>(R.id.chart_view)

            val chartPoints = points
                .sortedBy { it.x }
                .map { Entry(it.x.toFloat(), it.y.toFloat()) }

            val dataSet = LineDataSet(chartPoints, "points graph")
            dataSet.axisDependency = YAxis.AxisDependency.LEFT

            chartView.data = LineData(dataSet)
            chartView.invalidate()
        }
    }

    private fun extractPoints(): List<PointModel> {
        arguments?.getString(POINTS_KEY)?.let {
            val wrapped = Gson().fromJson(it, PointsWrapper::class.java)

            return wrapped.points
        }
        return emptyList()
    }

    private data class PointsWrapper(val points: List<PointModel>)

    companion object {
        private const val POINTS_KEY = "points"
        fun savePointsToBundle(points: List<PointModel>): Bundle = Bundle().apply {
            val pointsString = Gson().toJson(PointsWrapper(points))
            putString(POINTS_KEY, pointsString)
        }
    }
}