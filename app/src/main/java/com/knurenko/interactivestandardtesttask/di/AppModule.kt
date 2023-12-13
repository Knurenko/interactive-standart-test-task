package com.knurenko.interactivestandardtesttask.di

import com.knurenko.interactivestandardtesttask.data.mappers.PointResponseToModelMapper
import com.knurenko.interactivestandardtesttask.data.network.PointServiceFactory
import com.knurenko.interactivestandardtesttask.data.network.PointsService
import com.knurenko.interactivestandardtesttask.data.repo.PointsRepoImpl
import com.knurenko.interactivestandardtesttask.domain.repo.PointsRepository
import com.knurenko.interactivestandardtesttask.presentation.screens.main.MainContract
import com.knurenko.interactivestandardtesttask.presentation.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Knurenko Bogdan 12.12.2023
 */

@Module
class AppModule {

//    @Provides
//    fun provideResponseToModelMapper() = PointResponseToModelMapper()
//
//    @Provides
//    fun provideService(): PointsService = PointServiceFactory.create()

//    @Provides
//    fun providePointsRepo(): PointsRepository = PointsRepoImpl(
//        service = PointServiceFactory.create(),
//        responseToModelMapper = PointResponseToModelMapper()
//    )

    @Provides
    fun provideMainPresenter(): MainContract.Presenter =
        MainPresenter(
            PointsRepoImpl(
                service = PointServiceFactory.create(),
                responseToModelMapper = PointResponseToModelMapper()
            )
        )
}