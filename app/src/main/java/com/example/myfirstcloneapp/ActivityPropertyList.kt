package com.example.myfirstcloneapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_property_list.*
import kotlinx.android.synthetic.main.property_items.view.*
import kotlinx.android.synthetic.main.property_items.view.mainImage


class ActivityPropertyList : AppCompatActivity() {
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    var fileName: String = "STORE_DATA"
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = Intent(this, ActivityNews::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_list)
        var PropertySet = createData()
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(PropertySet)
        viewAdapter.callBack = object : ItemClickHandler {

            override fun onItemClicked(tempProp: ItemsProperty, view: View) {
                val editor: SharedPreferences.Editor = getSharedPreferences(fileName, Context.MODE_PRIVATE).edit()
                editor.putString("TITLE", tempProp.title)
                editor.putString("CONTENT", tempProp.content)
                editor.putInt("IMAGE_RESOURCE", tempProp.mainImage)
                editor.putBoolean("HEARTED", view.ic_heart.isChecked)
                editor.putBoolean("STARED", view.ic_star.isChecked)
                editor.commit()
                startActivity(intent)
            }

        }
        PropertyList.layoutManager = viewManager
        PropertyList.adapter = viewAdapter
        btn_back_category.setOnClickListener {
            finish()
        }


    }
    class MyAdapter(private val myDataset: ArrayList<ItemsProperty>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        var callBack: ItemClickHandler? = null


        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun initView(tempProp: ItemsProperty, callBack: ItemClickHandler?) {
                view.newsImage.setImageResource(tempProp.smallImage!!)
                view.newsTitle.text = tempProp.title
                view.createTime.text = tempProp.createTime
                view.newsContent.text = tempProp.content
                view.mainImage.setImageResource(tempProp.mainImage!!)
                view.ic_heart.setChecked(view.ic_heart.isChecked)
                view.ic_star.setChecked(view.ic_star.isChecked)

                view.setOnClickListener {
                    callBack?.onItemClicked(tempProp, view)
                }
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.property_items, parent, false)
            return MyViewHolder(view)
        }


        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.initView(myDataset[position], callBack)
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = myDataset.size
    }

    interface ItemClickHandler {
        fun onItemClicked(tempProp: ItemsProperty, view : View)
    }
    fun createData() : ArrayList<ItemsProperty> {
        var PropertySet = ArrayList<ItemsProperty>()

        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        PropertySet.add(
            ItemsProperty(
                "1 2 3 4 5 6",
                R.drawable.ic_discussion_forum_11,
                "2 hours ago",
                R.drawable.photo,
                getString(R.string.content_news),
                false,
                false
            )
        )
        return PropertySet
    }
}
