package com.tbadhit.mylocalization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.tbadhit.mylocalization.databinding.ActivityMainBinding

// Open "strings.xml" (res → values → strings.xml) add code
// Create Espanyol Lang :
// klik kanan pada direktori res → values kemudian pilih new → value resource file dan beri nama strings, jangan lupa untuk memasukan Locale di Chosen qualifiers kemudian pilih bahasa es:Spanish. Kalau sudah Anda bisa klik Finish
// Create French Lang :
// klik kanan pada direktori res → values kemudian pilih new → value resource file dan beri nama strings, jangan lupa untuk memasukan Locale di Chosen qualifiers kemudian pilih bahasa fr:French. Kalau sudah Anda bisa klik Finish
// Create Indonesia Lang :
// klik kanan pada direktori res → values → new → value resource file dan beri nama strings, jangan lupa untuk memasukan Locale di Chosen qualifiers kemudian pilih bahasa in:Indonesia. Kalau sudah Anda bisa klik Finish
// Create menu (res → new → android resource directory) name it "menu"
// Create "main_menu.xml" (menu → new → android resource file → main_menu.xml)
// Update code "main_menu.xml"
// Update code "activity_main.xml"
// Add code "MainActivity" (1) (2)
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // (1)
        val pokeCount = 3
        val hello = resources.getString(R.string.hello_world, "Tubagus Adhitya Permana", pokeCount, "Yoza Aprilio")

        // (1)
        binding.tvHello.text = hello

        // (1)
        val songCount = 5
        val pluralText = resources.getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount)
        binding.tvPlural.text = pluralText

        // (1)
        binding.tvXliff.text = resources.getString(R.string.app_homeurl)
    }

    // (2)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // (2)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}