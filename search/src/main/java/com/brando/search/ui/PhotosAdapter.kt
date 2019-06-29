package com.brando.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.brando.data.models.Photo
import com.brando.search.R
import java.lang.ref.WeakReference


class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoItemViewHolder>() {
    private val content = ArrayList<Photo>()
    private var locationListener = WeakReference<LocationListener>(null)

    interface LocationListener {
        fun onLocationClicked(locationName: String, addressName: String, latitude: Double, longitude: Double)
    }

    fun setSelectionListener(@Nullable listener: LocationListener) {
        locationListener = WeakReference(listener)
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, position: Int): PhotoItemViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return PhotoItemViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.layout_photo_item_view, viewGroup, false))
    }

    override fun onBindViewHolder(@NonNull viewHolder: PhotoItemViewHolder, position: Int) {
        viewHolder.bind(content[position])
        /*viewHolder.itemView.setOnClickListener {
            locationListener.get()?.onLocationClicked(

            )
        }*/
    }

    override fun getItemCount(): Int = content.size

    fun setContent(content: Array<Photo>) {
        this.content.clear()
        this.content.addAll(content)
        notifyDataSetChanged()
    }

    inner class PhotoItemViewHolder(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(photo: Photo) {
            //dataBinding.setVariable(BR.location, locationDomain)
            dataBinding.executePendingBindings()
        }
    }
}
