package com.knurenko.interactivestandardtesttask.data.repo

import com.knurenko.interactivestandardtesttask.data.mappers.PointResponseToModelMapper
import com.knurenko.interactivestandardtesttask.data.network.PointsService
import com.knurenko.interactivestandardtesttask.domain.model.PointModel
import com.knurenko.interactivestandardtesttask.domain.repo.PointsRepository
import kotlinx.coroutines.runBlocking

/**
 * @author Knurenko Bogdan 12.12.2023
 */
class PointsRepoImpl(
    private val service: PointsService,
    private val responseToModelMapper: PointResponseToModelMapper
) : PointsRepository {
    override fun fetchPoints(count: Int): List<PointModel> {
        return runBlocking {
            val response = service.fetchPoints(count)
            val points = response.points

            return@runBlocking points.map { responseToModelMapper.map(it) }
        }
    }
}