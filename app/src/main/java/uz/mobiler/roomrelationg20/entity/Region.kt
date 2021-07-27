package uz.mobiler.roomrelationg20.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.AssertionError

@Entity
data class Region(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
