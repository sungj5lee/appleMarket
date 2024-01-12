package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemLayoutBinding

class MyAdapter(val mItems: MutableList<myItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aProductName
        holder.address.text = mItems[position].aAddress
        holder.price.text = "%,d".format(mItems[position].aPrice)+"원"
        holder.likes.text = mItems[position].aLikes.toString()
        holder.comment.text = mItems[position].aCommentNum.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.imgItem
        val name = binding.textName
        val address = binding.textAddress
        val price = binding.textPrice
        val likes = binding.textLikes
        val comment = binding.textComments
    }
}