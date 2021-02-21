package com.thxallgrace.instagram_copy

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thxallgrace.instagram_copy.navigation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_add_photo) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(this, AddPhotoActivity::class.java))
                return true
            }
        } else {
            val fragmentToRun = when (item.itemId) {
                R.id.action_home -> DetailViewFragment()
                R.id.action_search -> GridFragment()
                R.id.action_favorite_alarm -> AlarmFragment()
                R.id.action_account -> UserFragment()
                else -> null
            }

            if (fragmentToRun != null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragmentToRun)
                    .commit()
                return true
            }
        }
        return false
    }
}
