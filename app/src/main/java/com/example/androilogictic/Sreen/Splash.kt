package com.example.androilogictic.Sreen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.androilogictic.R

class Splash : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_sreen)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_animation)

        val image = findViewById<ImageView>(R.id.imageLogo)
        val name = findViewById<TextView>(R.id.textName)

        image.startAnimation(topAnim)
        name.startAnimation(botAnim)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginSreen::class.java)
            val p1 = Pair.create<View, String>(image, "logo")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)
            startActivity(intent,options.toBundle())
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.


    }
}