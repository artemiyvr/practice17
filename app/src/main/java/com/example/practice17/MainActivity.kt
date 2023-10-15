import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.practice17.R

class MainActivity : AppCompatActivity() {

    private var isDarkTheme = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(if (isDarkTheme) R.style.AppThemeDark else R.style.AppThemeLight)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_theme -> {
                isDarkTheme = !isDarkTheme
                updateTheme(item)
                recreate()
                true
            }
            R.id.action_about -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTheme(item: MenuItem) {
        if (isDarkTheme) {
            item.setTitle("Сменить на светлую")
            item.setIcon(R.drawable.ic_dark_theme)
        } else {
            item.setTitle("Сменить на тёмную")
            item.setIcon(R.drawable.ic_light_theme)
        }
    }
}
