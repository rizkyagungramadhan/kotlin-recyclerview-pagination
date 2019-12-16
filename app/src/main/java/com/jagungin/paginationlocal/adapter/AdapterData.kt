package com.jagungin.paginationlocal.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.paginationlocal.R
import kotlinx.android.synthetic.main.item_data_content.view.*

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 16/12/2019.
 */
class AdapterData(private var listData: List<String>, private var listViewType: List<Int>) :
    RecyclerView.Adapter<AdapterData.ViewHolder>() {

    private val TAG = javaClass.simpleName

    companion object {
        val ITEM_VIEW_TYPE_CONTENT = 1
        val ITEM_VIEW_TYPE_LOADING = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterData.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return when (viewType) {
            ITEM_VIEW_TYPE_CONTENT -> ViewHolderContent(
                layoutInflater.inflate(
                    R.layout.item_data_content,
                    null
                )
            )
            else -> ViewHolderLoading(layoutInflater.inflate(R.layout.item_data_loading, null))
        }
    }

    override fun getItemCount(): Int = listData.size

    override fun getItemViewType(position: Int): Int = listViewType[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewType = listViewType[position]
        val data = listData[position]
        when (viewType) {
            ITEM_VIEW_TYPE_CONTENT -> {
                holder?.itemView.text_view_number_item_data_content.text = data
            }
            else -> {
            }
        }
    }

    fun refresh(listData: ArrayList<String>, listViewType: ArrayList<Int>) {
        Log.w("CEK AdapterData", "refreshing")
        this.listData = listData
        this.listViewType = listViewType
        notifyDataSetChanged()
    }


    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderContent(itemView: View) : ViewHolder(itemView)

    inner class ViewHolderLoading(itemView: View) : ViewHolder(itemView)


}