package com.example.bottomnavigation

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        //changeFragment(HomeFragment())
        bottomNav = findViewById(R.id.nav_view) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.navigation_order -> {
                    loadFragment(OrderFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.navigation_account -> {
                    loadFragment(AccountFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /*
    fun changeFragment(fragment: Fragment?) {
        if (fragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_view, fragment)
                .commit()
        }
    }
     */
/*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return super.onCreateOptionsMenu(menu)
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }
*/
    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.navigation_home){
            changeFragment(HomeFragment())
        }else if(item.itemId == R.id.navigation_order) {
            changeFragment(OrderFragment())
        }else if(item.itemId == R.id.navigation_account){
            changeFragment(AccountFragment())
        }else{
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Are you sure want to exit?")
                .setPositiveButton("YES", object : DialogInterface.OnClickListener{
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        finishAndRemoveTask()
                    }
                })
        }
        return super.onOptionsItemSelected(item)
    }
    */
}