package com.example.andriodkotlinbook.cut_stone_hand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import com.example.andriodkotlinbook.R

class CSP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csp)

        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener {
            //判斷EditText的字數是否小於一，若成立無法繼續猜拳
            if (ed_name.length() < 1) {
                tv_text.text = "請輸入玩家姓名"
                return@setOnClickListener
            }
            //取出EditText文字作為玩家姓名並用變數儲存
            val playerName = ed_name.text
            //亂數產生介於0~1之間不含1的小數，將其乘以3變成0~2後，取整數做為電腦的出拳
            val comMora = (Math.random() * 3).toInt()
            //將玩家出拳結果對應成字串並用變數儲存
            val playerMoraText = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "不"
            }
            //將電腦出拳結果對應成字串並用變數儲存
            val comMoraText = when (comMora) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            //顯示玩家姓名與雙方出拳結果
            //$的作用 稱作插值or字符串模板
            //範例 https://zhuanlan.zhihu.com/p/149716369
            tv_name.text = "名字\n$playerName"
            tv_mmora.text = "玩家出拳\n$playerMoraText"
            tv_cmora.text = "電腦出拳\n$comMoraText"
            //用三個判斷式決定勝負並顯示猜拳結果
            // /n
            when {
                btn_scissor.isChecked && comMora == 2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1 -> {
                    tv_winner.text = "勝利者\n$playerName"
                    tv_text.text = "恭喜你獲勝了!!!"
                }

                btn_scissor.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "電腦獲勝了!!!"
                }

                else -> {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "請在試一次"
                }

            }
        }


    }
}
