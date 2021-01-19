package geekbarains.material.ui

import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import geekbarains.material.R
import geekbarains.material.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = this.getSharedPreferences("theme", MODE_PRIVATE)


        if (pref.getString("theme", "Light Theme") == "Light Theme"){
            setTheme(R.style.AppTheme)
        }

        if (pref.getString("theme", "Light Theme") == "Dark Theme"){
            setTheme(R.style.MyDarkAppTheme)
        }

        if (pref.getString("theme", "Light Theme") == "Custom Theme"){
            setTheme(R.style.AppTheme_Orange)
        }


        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}
