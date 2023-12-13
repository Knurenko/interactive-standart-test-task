package com.knurenko.interactivestandardtesttask.domain.repo

import com.knurenko.interactivestandardtesttask.domain.model.PointModel

/**
 * @author Knurenko Bogdan 12.12.2023
 */
interface PointsRepository {
    fun fetchPoints(count: Int): List<PointModel>
}