package com.stone.movieticket.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stone.movieticket.ui.fragment.LoginFragment
import com.stone.movieticket.ui.fragment.RegisterFragment

class LoginPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            LoginFragment()
        } else {
            RegisterFragment()
        }
    }
}