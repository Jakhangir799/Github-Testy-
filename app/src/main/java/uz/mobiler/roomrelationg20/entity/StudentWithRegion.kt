package uz.mobiler.roomrelationg20.entity

import androidx.room.Embedded
import androidx.room.Relation

data class StudentWithRegion(
    @Embedded val student: Student,
    @Relation(parentColumn = "region_id", entityColumn = "id")
    val region: Region
)
