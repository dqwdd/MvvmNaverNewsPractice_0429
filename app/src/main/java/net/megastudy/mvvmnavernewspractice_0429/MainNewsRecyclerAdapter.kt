package net.megastudy.mvvmnavernewspractice_0429

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.megastudy.mvvmnavernewspractice_0429.data.Items

class MainNewsRecyclerAdapter(
    private val mContext: Context,
    private val mList: List<Items>,
) :
    RecyclerView.Adapter<MainNewsRecyclerAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvContent: TextView = view.findViewById(R.id.tv_content)

        fun bind(data: Items) {
            tvTitle.text = data.title
            tvContent.text = data.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_news_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}