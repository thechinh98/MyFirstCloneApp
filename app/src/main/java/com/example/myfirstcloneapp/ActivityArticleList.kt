package com.example.myfirstcloneapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_article.*
import kotlinx.android.synthetic.main.items_article.view.*

class ActivityArticleList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        var Articleset = ArrayList<ItemsArticle>()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_article)
        Articleset.add(
            ItemsArticle(
                R.mipmap.news_image1,
                "Quick Brown Fox Jumps Over",
                "TRAVELLING",
                "16 MAY 2016",
                "Synth polaroid bitters chillwave pickled. Vegan\n" +
                        "disrupt tousled, Portland keffiyeh aesthetic food",
                "254 LIKES",
                "14 COMMENTS"))
        Articleset.add(
            ItemsArticle(
               R.mipmap.news_image2,
                "Quick Brown Fox Jumps Over",
                "HOBBY",
                "16 MAY 2016",
                "Synth polaroid bitters chillwave pickled. Vegan\n" +
                        "disrupt tousled, Portland keffiyeh aesthetic food",
                "254 LIKES",
                "14 COMMENTS"))
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(Articleset)

        ArticleList.layoutManager = viewManager
        ArticleList.adapter = viewAdapter

    }
    class MyAdapter(private val myArticleList : ArrayList<ItemsArticle>) :
            RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.items_article, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return myArticleList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.initView(myArticleList[position])
        }

        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
            fun initView(tempArticle: ItemsArticle){
                view.img_article_item.setImageResource(tempArticle.imageArticle!!)
                view.txt_item_article_title.text = tempArticle.titleArticle
                view.txt_item_article_status.text = tempArticle.statusArticle
                view.txt_item_article_content.text = tempArticle.contentArticle
                view.txt_item_article_date.text = tempArticle.dateArticle
                view.txt_likes.text = tempArticle.likeArticle
                view.txt_comments.text = tempArticle.commentArticle
            }
        }

    }


}
