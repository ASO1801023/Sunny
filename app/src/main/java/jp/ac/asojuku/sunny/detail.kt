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
            fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」の部分にフラグメントを切り替え
                .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない ）
                .commit();//トランザクション完了


        }
        //ランキング
        this.ranking.setOnClickListener{
            val fragment = fragment_ranking();
            val fragmentManager = this.supportFragmentManager;
            val fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」の部分にフラグメントを切り替え
                .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない ）
                .commit();//トランザクション完了

        }
        //総降水量
        this.total_precipitation.setOnClickListener{
            val fragment = fragment_total_precipitation();
            val fragmentManager = this.supportFragmentManager;
            val fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」の部分にフラグメントを切り替え
                .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない ）
                .commit();//トランザクション完了

        }

    }
}
