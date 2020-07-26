package dk.w4.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dk.w4.hiltdemo.ui.CarsViewModel
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val carsViewModel: CarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carsViewModel.carsLiveData.observe(this, Observer {
            var text = ""
            it.forEach {
                text += "${it.title}\n"
            }
            tvDisplay.text = text
        })

        carsViewModel.onViewReady()
    }
}