package com.example.demodesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val menuList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        menuList.add("Terms of service")
        menuList.add("Privacy policy")
        menuList.add("Cookies")

        setView(menuList)


    }

    private fun setView(menuList: ArrayList<String>) {
        recyclerviewTodo.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MenuAdapter(menuList,this@MainActivity,"Main",object :MenuAdapter.ItemClickListener{
                override fun onItemClick() {
                    val intent = Intent(this@MainActivity, TermsOfServiceActivity::class.java)
                    startActivityForResult(intent,1000)
                }
            })

            adapter!!.notifyDataSetChanged()

            val itemDecorator =
                    DividerItemDecoration(
                            recyclerviewTodo.context,
                            DividerItemDecoration.VERTICAL
                    )
            ContextCompat.getDrawable(this@MainActivity, R.drawable.item_decorator)
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
    }

    override fun onResume() {
        super.onResume()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode ==1000){
            menuList.clear()
            menuList.add("Terms of service")
            menuList.add("Privacy policy")
            menuList.add("Cookies")
            setView(menuList)
        }
    }
}