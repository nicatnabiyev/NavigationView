package com.nicatnabiyev88.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

// implement NavigationView.OnNavigationItemSelectedListener
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set custom toolbar as support
        setSupportActionBar(toolbar)

        //create toogle button for drawer navigatin view
        val toggle = ActionBarDrawerToggle(this, drawer_layout,toolbar,
        R.string.navigation_drawer_open,R.string.navigation_drawer_close)

        //set toggle button to drawer nav view
        drawer_layout.addDrawerListener(toggle)

        //navigation open close state sync
        toggle.syncState()

        //set click listener to nav view
        nav_view.setNavigationItemSelectedListener(this)
    }

    //when item nav view item selected
    var message = ""
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_message -> message = "message"
            R.id.nav_chat -> message = "chat"
            R.id.nav_profile -> message = "profile"
            R.id.nav_share -> message = "share"
            R.id.nav_send -> message = "send"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    //when main BACK button clicked
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else{
        super.onBackPressed()
        }
    }
}