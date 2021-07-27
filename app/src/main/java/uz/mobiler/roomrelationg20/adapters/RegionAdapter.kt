package uz.mobiler.roomrelationg20.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import uz.mobiler.roomrelationg20.databinding.ItemRegionBinding
import uz.mobiler.roomrelationg20.entity.Region

class RegionAdapter(val regionList: List<Region>) : BaseAdapter() {

    override fun getCount(): Int = regionList.size

    override fun getItem(position: Int): Region = regionList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemRegionBinding: ItemRegionBinding
        if (convertView == null) {
            itemRegionBinding =
                ItemRegionBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            itemRegionBinding = ItemRegionBinding.bind(convertView)
        }
        val region = regionList[position]
        itemRegionBinding.regionTitle.text = region.name
        return itemRegionBinding.root
    }
}