package uz.mobiler.roomrelationg20.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mobiler.roomrelationg20.databinding.ItemStudentBinding
import uz.mobiler.roomrelationg20.entity.StudentWithRegion

class StudentAdapter(val list: List<StudentWithRegion>) :
    RecyclerView.Adapter<StudentAdapter.Vh>() {

    inner class Vh(var itemStudentBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemStudentBinding.root) {

//        fun onBind(studentWithRegion: StudentWithRegion) {
//            itemStudentBinding.apply {
//                nameTv.text = studentWithRegion.student.name
//                regionTv.text = studentWithRegion.region.name
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
//        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}