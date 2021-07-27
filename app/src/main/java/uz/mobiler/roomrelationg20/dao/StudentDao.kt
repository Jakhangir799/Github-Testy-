package uz.mobiler.roomrelationg20.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import uz.mobiler.roomrelationg20.entity.Student
import uz.mobiler.roomrelationg20.entity.StudentWithRegion

@Dao
interface StudentDao {

    @Insert
    fun addStudent(student: Student)

//    @Query("select * from student")
//    fun getAllStudents(): List<Student>

    @Transaction
    @Query("select * from student")
    fun getStudents(): List<StudentWithRegion>
}