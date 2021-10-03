package pe.edu.ulima.pm.cookies

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity:AppCompatActivity() {
    private lateinit var eteUsername : EditText

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_login)

        val butLogin : Button = findViewById(R.id.butIngresarVertical)
        butLogin.setOnClickListener{ _ : View ->
            val intent : Intent = Intent()
            intent.setClass(this, MainActivity::class.java)

            startActivity(intent)

        }


    }
}