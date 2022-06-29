package com.example.subimisidicoding.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.subimisidicoding.R
import com.example.subimisidicoding.databinding.ActivityNavigationBinding
import com.example.subimisidicoding.ui.fragment.FavoriteFragment
import com.example.subimisidicoding.ui.fragment.HomeFragment

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)

        setupBotNav()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            title = "Home"
        }

        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.item_profile) {
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupBotNav() {
        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    title = "Home"
                    replaceFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                else -> {
                    title = "Favorite"
                    replaceFragment(FavoriteFragment())
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.layout_container,
            fragment
        ).addToBackStack(Fragment::class.java.simpleName).commit()
    }

}