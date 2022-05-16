package com.anil.kisannetworkdemo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anil.kisannetworkdemo.fragments.ContactDetailsFr
import com.anil.kisannetworkdemo.fragments.ContactFr

private const val NUM_TABS = 2

class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ContactFr()
        }
        return ContactDetailsFr()
    }
}