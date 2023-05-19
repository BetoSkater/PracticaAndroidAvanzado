package com.albertojr.practicaandroidavanzado.UI.MainActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    companion object{
        private const val TAG_TOKEN = "MyToken"
        private const val TAG_PREFERENCES = "MyPreferences"
        fun launch(context: Context, token: String){
            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra(TAG_TOKEN, token)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //TODO assignate the token value to the MainActivityViewModel



        setUpViewModelWithToken()

        //  retrieveTokenFromSharedPreferences()
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
    private fun setUpViewModelWithToken() {
        val token = intent.getStringExtra(TAG_TOKEN).toString()
        viewModel = MainActivityViewModel(token)
        viewModel.printToken()
    }
    fun retrieveTokenFromSharedPreferences(){

        /*
        getPreferences(Context.MODE_PRIVATE).apply {
            //val token = getString(TAG_TOKEN,"")
            token = getString(TAG_TOKEN,"").toString()
            token?.let {
                Log.d("MainActivity", "The token in mainActivity is $token")
            }
        }
         */

        val sp = getSharedPreferences(TAG_PREFERENCES, MODE_PRIVATE)
        val token = sp.getString(TAG_TOKEN,"")

    }
}