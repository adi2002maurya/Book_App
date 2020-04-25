package com.maurya.hamburger.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maurya.hamburger.activity.DescriptionActivity
import com.maurya.hamburger.model.book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<book>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtbookName: TextView = view.findViewById(com.maurya.hamburger.R.id.tony1)
        val txtbookAuthor: TextView = view.findViewById(com.maurya.hamburger.R.id.bookAuthor)
        val txtbookrating: TextView = view.findViewById(com.maurya.hamburger.R.id.rate)
        val txtbookprice: TextView = view.findViewById(com.maurya.hamburger.R.id.price)
        val bookimg: ImageView = view.findViewById(com.maurya.hamburger.R.id.tony)
        val llcontent: RelativeLayout = view.findViewById(com.maurya.hamburger.R.id.llcontent)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.maurya.hamburger.R.layout.recycler_dashboard, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtbookName.text = book.bookName
        holder.txtbookAuthor.text = book.bookAuthor
        holder.txtbookrating.text = book.bookRating
        holder.txtbookprice.text = book.bookPrice

        //   holder.bookimg.setImageResource(book.bookImage)

        Picasso.get().load(book.bookImage).into(holder.bookimg)

        holder.llcontent.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id", book.bookId)
            context.startActivity(intent)
        }

    }
}