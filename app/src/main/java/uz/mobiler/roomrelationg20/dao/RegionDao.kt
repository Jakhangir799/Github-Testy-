package uz.mobiler.roomrelationg20.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.mobiler.roomrelationg20.entity.Region

@Dao
interface RegionDao {

    @Insert
    fun addRegion(region: Region)

    @Query("select * from region")
    fun getAllRegions(): List<Region>

    @Delete
    fun deleteRegion(region: Region)
}