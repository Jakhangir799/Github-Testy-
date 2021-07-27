package uz.mobiler.roomrelationg20.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.NO_ACTION

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Region::class,
            parentColumns = ["id"],
            childColumns = ["region_id"],
            onDelete = NO_ACTION
        )
    ]
)
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "region_id")
    val regionId: Int,
    val course: Int
)
