package com.claze2022.attraction1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.claze2022.attraction1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var fragments = ArrayList<Fragment?>()
    var drawerToggle : ActionBarDrawerToggle? = null




    val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fragments.add(HomeFragment())
        fragments.add(CultureFragment())
        fragments.add(DinningFragment())
        fragments.add(FavoriteFragment())
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragments[0]!!).commit()

        drawerToggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)

        drawerToggle!!.syncState()
        binding.drawerLayout.addDrawerListener(drawerToggle!!)

       //binding.drawerLayout.closeDrawer(binding.nav)
        binding.nav.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawer(binding.nav)
            true
        }




        binding.bnv.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                  when(item.itemId) {
                      R.id.menu_bnv_home -> {
                          supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragments[0]!!).commit()
                      }
                      R.id.menu_bnv_culture -> {
                          supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragments[1]!!).commit()

                      }
                      R.id.menu_bnv_dinnigroom -> {
                          supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragments[2]!!).commit()
                      }

                      R.id.menu_bnv_favorite -> {
                          supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragments[3]!!).commit()
                      }
                  }
                  return true



            }

        })

       }


    }



