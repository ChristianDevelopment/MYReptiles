package com.example.myreptil

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myreptil.data.ViewModel
import com.example.myreptil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel : ViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // popup onclick menu

        val add_button = binding.ivAdd

        add_button.setOnClickListener {
            showPopupAdd(add_button)
//            add_button.alpha = 0.5f // für abschwächung farbe
        }
        val meal_button = binding.ivMeal

        meal_button.setOnClickListener {
            showPopupMeal(meal_button)
        }

        val search_button = binding.ivSearch

        val menu_button = binding.ivMenu

        val qr_button = binding.ivQrCode

        menu_button.setOnClickListener {
            findNavController(R.id.fragment_view).navigate(R.id.fragment_Tiere) // search fragment
        }

        search_button.setOnClickListener {
            findNavController(R.id.fragment_view).navigate(R.id.searchFragment) // search fragment
        }

        qr_button.setOnClickListener {
            findNavController(R.id.fragment_view).navigate(R.id.errorFragment)
            // api call ????
        }
    }

    private fun showPopupAdd(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.add_menu)

        popup.setOnMenuItemClickListener(
            PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

                when (item!!.itemId) {
                    R.id.add_tier -> {
                        findNavController(R.id.fragment_view).navigate(R.id.detailCardFragment2)
                    }
                    R.id.add_gruppe -> {
                        findNavController(R.id.fragment_view).navigate(R.id.gruppeSave)
                    } // ändern
                }

                true
            }
        )

        popup.show()
    }

    private fun showPopupMeal(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.meal_menu)

        popup.setOnMenuItemClickListener(
            PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

                when (item!!.itemId) {
                    R.id.fuetterung -> {
                        findNavController(R.id.fragment_view).navigate(R.id.fuetterungFragment)
                    }
                    R.id.haeutung -> {
                        findNavController(R.id.fragment_view).navigate(R.id.huattungFragment)
                    }
                    R.id.arzt_besuch -> {
                        findNavController(R.id.fragment_view).navigate(R.id.arztBesuchFragment)
                    }
                }

                true
            }
        )

        popup.show()
    }
}
