package jp.ac.asojuku.sunny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onResume() {
        super.onResume()

        this.ameritu_score.setOnClickListener{
            val fragment = fragment_ameritu_score();
            val fragmentManager = this.supportFragmentManager;
            val fragmentTransaction = fragmentManager.beginTransaction();

        }
    }
}
