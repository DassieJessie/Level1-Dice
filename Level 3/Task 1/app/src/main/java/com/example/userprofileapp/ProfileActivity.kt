package com.example.userprofileapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

//const val PROFILE_EXTRA = "PROFILE_EXTRA"

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"

        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {
            idName.text = getString(R.string.name, profile.firstName, profile.lastName)
            idDescription.text = profile.description
            if (profile.imageUri != null) idProfilePic.setImageURI(profile.imageUri)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    companion object {
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }
}