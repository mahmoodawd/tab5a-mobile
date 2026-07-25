package dev.awd.tab5a.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.awd.tab5a.core.database.Tab5aDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): Tab5aDatabase = Room.databaseBuilder(
        context,
        Tab5aDatabase::class.java,
        "tab5a_db"
    ).build()

    @Provides
    @Singleton
    fun provideMealDao(database: Tab5aDatabase) = database.mealDao()
}
