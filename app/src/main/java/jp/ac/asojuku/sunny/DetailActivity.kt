package jp.ac.asojuku.sunny

import android.R.attr
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_ranking.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onResume() {
        super.onResume()

        this.ameritu_score.setOnClickListener{
            val database = FirebaseDatabase.getInstance().getReference().child("users").child("user2").child("score")

            database.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var score = snapshot.value

                    val bundle = Bundle()
                    bundle.putString("value", "$score")

                    if (score != null) {

                        score = score as Long

                        //雨率判定
                        if (score <= 45) { //晴れ
                            val fragment = AmerituSunnyFragment()
                            fragment.arguments = bundle
                            val fragmentManager = supportFragmentManager
                            val fragmentTransaction = fragmentManager.beginTransaction()
                            fragmentTransaction.replace(R.id.container,fragment)//画面の「id:container」の部分にフラグメントを切り替え
                                .addToBackStack(null)//元のフラグメントをバックスタックに保存（今回は何もしない ）
                                .commit()//トランザクション完了
                        } else if (score in 46..55){ //普通
                            val fragment = AmerituNomalFragment()
                            fragment.arguments = bundle
                            val fragmentManager = supportFragmentManager
                            val fragmentTransaction = fragmentManager.beginTransaction()
                            fragmentTransaction.replace(R.id.container,fragment)
                                .addToBackStack(null)
                                .commit()
                        } else if (score >= 56){ //雨
                            val fragment = AmerituRainyFragment()
                            fragment.arguments = bundle
                            val fragmentManager = supportFragmentManager
                            val fragmentTransaction = fragmentManager.beginTransaction()
                            fragmentTransaction.replace(R.id.container,fragment)
                                .addToBackStack(null)
                                .commit()
                        }
                    } else { //scoreがnullの場合
                        val fragment = UnknownFragment()
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.container,fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    //エラー処理
                }

            })
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
