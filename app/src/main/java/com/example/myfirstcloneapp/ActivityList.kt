package com.example.myfirstcloneapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reddit.indicatorfastscroll.FastScrollItemIndicator
//import com.reddit.indicatorfastscroll.FastScrollItemIndicator
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.province.view.*


class ActivityList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        var Dataset = ArrayList<String>()
        val intent = Intent(this, ActivityProvince::class.java)
        Dataset.add("Privilage")
        Dataset.add("Hello World")
        Dataset.sort()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val searchBarView = findViewById<View>(R.id.search_bar)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(Dataset)
        viewAdapter.callBack = object : ItemClickHandler {
            override fun onItemClicked(content: String) {
                intent.putExtra("province_name", content)
                startActivity(intent)
            }
        }
        countryList.layoutManager = viewManager
        countryList.adapter = viewAdapter
        fastscroller.setupWithRecyclerView(recyclerView,
            {position ->
                val item = Dataset[position]
                FastScrollItemIndicator.Text(
                    item.substring(0,1).toUpperCase()
                )
            })
    }

    class MyAdapter(private val myDataset: ArrayList<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        var callBack: ItemClickHandler? = null

        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

            fun initView(tempStr: String, callBack: ItemClickHandler?) {
                view.tv_province_name.text = tempStr
                view.setOnClickListener {
                    callBack?.onItemClicked(tempStr)
                }

            }

        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.province, parent, false)
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
        fun onItemClicked(content: String)
    }
}

