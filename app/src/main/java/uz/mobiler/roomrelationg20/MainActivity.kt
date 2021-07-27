package uz.mobiler.roomrelationg20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.mobiler.roomrelationg20.adapters.RegionAdapter
import uz.mobiler.roomrelationg20.adapters.StudentAdapter
import uz.mobiler.roomrelationg20.database.AppDatabase
import uz.mobiler.roomrelationg20.databinding.ActivityMainBinding
import uz.mobiler.roomrelationg20.entity.Region
import uz.mobiler.roomrelationg20.entity.Student
import uz.mobiler.roomrelationg20.entity.StudentWithRegion

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase

    lateinit var regionList: List<Region>
    lateinit var regionAdapter: RegionAdapter

    lateinit var list: ArrayList<StudentWithRegion>
    lateinit var studentAdapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDatabase = AppDatabase.getInstance(this)
        regionList = ArrayList(appDatabase.regionDao().getAllRegions())
        regionAdapter = RegionAdapter(regionList)

        list = ArrayList(appDatabase.studentDao().getStudents())
        studentAdapter = StudentAdapter(list)

        binding.apply {
            spinner.adapter = regionAdapter
            rv.adapter = studentAdapter
            saveBtn.setOnClickListener {
                val name = edit1.text.toString()
                val region = regionList[spinner.selectedItemPosition]
                val student = Student(name = name, regionId = region.id, course = 1)
                appDatabase.studentDao().addStudent(student)
                list.add(StudentWithRegion(student, region))
                studentAdapter.notifyItemInserted(list.size)
            }

            deleteBtn.setOnClickListener {
                appDatabase.regionDao().deleteRegion(Region(2, "Navoiy"))
            }
        }
    }
}