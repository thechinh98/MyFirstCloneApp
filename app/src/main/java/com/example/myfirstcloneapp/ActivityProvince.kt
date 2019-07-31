package com.example.myfirstcloneapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_province.*
import kotlinx.android.synthetic.main.province_properties.view.*

class ActivityProvince : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var adapter: PropAdapter?
        var propList = ArrayList<ItemsProvince>()

        val intent1 = Intent(this, ActivityPropertyList::class.java)
        val intent = getIntent()

        var tmpStr: String = intent.getStringExtra("province_name")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        var provinceName: TextView = findViewById(R.id.txt_province_name)
        provinceName.setText(tmpStr)
        propList.add(ItemsProvince("Community", R.drawable.ic_icon_1, "14 items"))
        propList.add(ItemsProvince("Housing", R.drawable.ic_housing_8, "8 items"))
        propList.add(ItemsProvince("Jobs", R.drawable.ic_jobs_12, "12 items"))
        propList.add(ItemsProvince("Pesonal", R.drawable.ic_personal_8, "8 items"))
        propList.add(ItemsProvince("For Sale", R.drawable.ic_for_sale_22, "22 items"))
        propList.add(ItemsProvince("Discussion Forum", R.drawable.ic_discussion_forum_11, "11 items"))
        adapter = PropAdapter(this, propList)

        btn_back_province.setOnClickListener {
            finish()
        }
        gvProp.adapter = adapter

        gvProp.setOnItemClickListener { parent, view, position, id ->


            if (position == 0) {
                startActivity(intent1)
            } else {
                Toast.makeText(this, propList.get(position).name, Toast.LENGTH_SHORT).show()
            }

        }


    }

    class PropAdapter : BaseAdapter {
        var propList: ArrayList<ItemsProvince>
        var context: Context? = null

        constructor(context: Context, propList: ArrayList<ItemsProvince>) {
            this.context = context
            this.propList = propList
        }

        override fun getCount(): Int {
            return propList.size
        }

        override fun getItem(p0: Int): Any {
            return propList[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            val prop = this.propList[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var propView = inflator.inflate(R.layout.province_properties, null)
            propView.img_prop.setImageResource(prop.image!!)
            propView.txt_name.text = prop.name
            propView.txt_quantity.text = prop.quantity

            return propView

        }
    }
}
