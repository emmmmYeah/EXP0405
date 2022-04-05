package com.example.exp_frag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG="@@MainActivity"

    var currentFragment=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
initFrag()
    }

    private fun initFrag() {

    }


    private fun initView() {
        var fragmentManager=supportFragmentManager
        var trans=fragmentManager.beginTransaction()
        var chats = findViewById<RelativeLayout>(R.id.rl_chats).setOnClickListener(this)
        var contacts = findViewById<RelativeLayout>(R.id.rl_contacts).setOnClickListener(this)
        var discover = findViewById<RelativeLayout>(R.id.rl_discover).setOnClickListener(this)
        var me = findViewById<RelativeLayout>(R.id.rl_me).setOnClickListener(this)
        trans.replace(R.id.content_layout,chatsFragment()).commit()
    }

    override fun onClick(view: View?) {
        var fragmentManager=supportFragmentManager
        var trans=fragmentManager.beginTransaction()
        when (view?.id) {
            R.id.rl_chats -> {
                Log.d(TAG,"click chats")
                addOrShowFragment(trans,chatsFragment())
            }
            R.id.rl_contacts -> {
                Log.d(TAG,"click rl_contacts")
                addOrShowFragment(trans,contactsFragment())
            }
            R.id.rl_discover -> {
                Log.d(TAG,"click rl_discover")
                addOrShowFragment(trans,discoverFragment())
            }
            R.id.rl_me -> {
                addOrShowFragment(trans,meFragment())
            }
        }
    }
    private fun addOrShowFragment(transaction: FragmentTransaction,fragment: Fragment){//点击这个先隐藏之前的然后再显示点击的相应的Frag
        var fragmentManager=supportFragmentManager
        var trans=fragmentManager.beginTransaction()
        transaction.replace(R.id.content_layout,fragment).commit()



    }

}