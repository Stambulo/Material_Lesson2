package geekbarains.material.ui.themes

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import geekbarains.material.R
import kotlinx.android.synthetic.main.fragment_themes.*

class ThemesFragment : Fragment() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_themes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chipGroup.setOnCheckedChangeListener { chipGroup, position ->

            chipGroup.findViewById<Chip>(position)?.let {
                when (it.text){
                    "Light Theme" -> {
                        Toast.makeText(context, "Выбран ${it.text}", Toast.LENGTH_SHORT).show()
                        sharedPref.edit().putString("theme", "Light Theme").apply()
                        activity?.recreate()
                    }

                    "Dark Theme" -> {
                        Toast.makeText(context, "Выбран ${it.text}", Toast.LENGTH_SHORT).show()
                        sharedPref.edit().putString("theme", "Dark Theme").apply()
                        activity?.recreate()
                    }

                    "Custom Theme" -> {
                        Toast.makeText(context, "Выбран ${it.text}", Toast.LENGTH_SHORT).show()
                        sharedPref.edit().putString("theme", "Custom Theme").apply()
                        activity?.recreate()
                    }

                    else -> Toast.makeText(context, "Else case $position, ${it.text}",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPref = context.getSharedPreferences("theme", 0)
    }
}
