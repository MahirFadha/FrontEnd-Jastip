package com.example.cobaproject.di

import android.content.Context
import androidx.room.Room
import com.example.cobaproject.data.local.AppDatabase
import com.example.cobaproject.data.local.UserDao
import com.example.cobaproject.data.remote.ApiService
import com.example.cobaproject.data.repository.UserRepositoryImpl
import com.example.cobaproject.domain.repository.UserRepository
import com.example.cobaproject.domain.usecase.RegisterUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://your.api.url/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "user_database").build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Provides
    fun provideUserRepository(api: ApiService, dao: UserDao): UserRepository =
        UserRepositoryImpl(api, dao)

    @Provides
    fun provideRegisterUseCase(repo: UserRepository): RegisterUserUseCase =
        RegisterUserUseCase(repo)

}