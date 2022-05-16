package com.anil.kisannetworkdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.anil.kisannetworkdemo.adapters.PagerAdapter
import com.anil.kisannetworkdemo.databinding.ActivityMainBinding
import com.anil.kisannetworkdemo.fragments.ContactDetailsFr
import com.anil.kisannetworkdemo.fragments.ContactFr
import com.anil.kisannetworkdemo.utils.Constants.Companion.CONTACT_DETAILS
import com.anil.kisannetworkdemo.viewModel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val animalsArray = arrayOf(
        "Contact",
        "History")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white))
        binding.toolbar.title = "Kisan Network Demo"
        setContentView(binding.root)




        val fragments = ArrayList<Fragment>()
        fragments.add(ContactFr())
        fragments.add(ContactDetailsFr())

        val adapter = PagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()


    }


}