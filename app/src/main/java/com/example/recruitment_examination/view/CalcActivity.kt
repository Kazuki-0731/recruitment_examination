package com.example.recruitment_examination.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recruitment_examination.R
import com.example.recruitment_examination.databinding.ActivityCalcBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class CalcActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var binding: ActivityCalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calc)

        replaceFragment(CalcFragment.newInstance(), R.id.calc_content_view)
    }

    private fun replaceFragment(fragment: Fragment, layoutResId: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(layoutResId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}