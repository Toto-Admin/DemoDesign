package com.example.demodesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class TermsOfServiceActivity : AppCompatActivity() {

    val menuList: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        menuList.add("Lorem ipsum dolor sit amet")
        menuList.add("Lorem ipsum dolor sit amet")
        menuList.add("Lorem ipsum dolor sit amet")
        menuList.add("Lorem ipsum dolor sit amet")
        menuList.add("Lorem ipsum dolor sit amet")
        menuList.add("Lorem ipsum dolor sit amet")

        recyclerviewTodo.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@TermsOfServiceActivity)
            adapter = MenuAdapter(menuList,this@TermsOfServiceActivity,"Terms",object :MenuAdapter.ItemClickListener{
                override fun onItemClick() {

                }
            })

            adapter!!.notifyDataSetChanged()

            val itemDecorator =
                    DividerItemDecoration(
                            recyclerviewTodo.context,
                            DividerItemDecoration.VERTICAL
                    )
            ContextCompat.getDrawable(this@TermsOfServiceActivity, R.drawable.item_decorator)
                    ?.let {
                        itemDecorator.setDrawable(
                                it
                        )
                    }
            recyclerviewTodo.addItemDecoration(
                    itemDecorator
            )
            recyclerviewTodo.visibility = View.VISIBLE
        }

        backBtn.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}