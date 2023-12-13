package com.knurenko.interactivestandardtesttask.presentation.screens.points

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.knurenko.interactivestandardtesttask.R
import com.knurenko.interactivestandardtesttask.domain.model.PointModel

/**
 * @author Knurenko Bogdan 13.12.2023
 */
class PointsListAdapter(private val items: List<PointModel>) :
    RecyclerView.Adapter<PointsListAdapter.PointViewHolder>() {

    inner class PointViewHolder(itemView: View) : ViewHolder(itemView) {
        private val xValue: TextView
        private val yValue: TextView

        init {
            xValue = itemView.findViewById(R.id.point_x_value)
            yValue = itemView.findViewById(R.id.point_y_value)
        }

        fun bindView(point: PointModel) {
            xValue.text = itemView.context.getString(R.string.point_x_value, point.x)
            yValue.text = itemView.context.getString(R.string.point_y_value, point.y)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder =
        PointViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.point_item_view, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.bindView(items[position])
    }
}