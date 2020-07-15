package jp.ac.asojuku.sunny

import android.R.attr
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onResume() {
        super.onResume()

        this.ameritu_score.setOnClickListener{
            val score = (36..65).random()

            if (score <= 45) { //晴れ
                val fragment = AmerituSunnyFragment()
                val fragmentManager = this.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」の部分にフラグメントを切り替え
                    .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない ）
                    .commit()//トランザクション完了
            } else if (score in 46..55){ //普通
                val fragment = AmerituNomalFragment()
                val fragmentManager = this.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,fragment)
                    .addToBackStack(null)
                    .commit()
            } else if (score >= 56){ //雨
                val fragment = AmerituRainyFragment()
                val fragmentManager = this.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,fragment)
                    .addToBackStack(null)
                    .commit()
            } else { //データなし
                val fragment = UnknownFragment()
                val fragmentManager = this.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        //ランキング
        this.ranking.setOnClickListener{
            val fragment = fragment_ranking()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit()

        }
        //総降水量
        this.total_precipitation.setOnClickListener{
            val fragment = fragment_total_precipitation()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit()

        }

    }
}
