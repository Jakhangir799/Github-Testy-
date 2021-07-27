package uz.mobiler.roomrelationg20.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import uz.mobiler.roomrelationg20.dao.RegionDao
import uz.mobiler.roomrelationg20.dao.StudentDao
import uz.mobiler.roomrelationg20.entity.Region
import uz.mobiler.roomrelationg20.entity.Student

@Database(entities = [Student::class, Region::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun regionDao(): RegionDao

    companion object {
        private var appDatabase: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
            }
            return appDatabase!!
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE student ADD COLUMN course INTEGER NOT NULL DEFAULT 0"
                )
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL(
//                    "ALTER TABLE student ADD COLUMN course INTEGER NOT NULL DEFAULT 0"
//                )
            }
        }
    }


}