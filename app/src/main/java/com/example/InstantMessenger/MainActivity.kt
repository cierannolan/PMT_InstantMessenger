package com.example.InstantMessenger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var auth = Firebase.auth

        findViewById<Button>(R.id.registerBtn).setOnClickListener {
            val email = findViewById<EditText>(R.id.registerEmail).text.toString().trim()
            val username = findViewById<EditText>(R.id.registerUsername).toString()
            val password = findViewById<EditText>(R.id.registerPassword).text.toString()
            val firstName = findViewById<EditText>(R.id.registerFirstName).toString()
            val surname = findViewById<EditText>(R.id.registerSurname).toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("tst1", "createUserWithEmail:success")
                    } else {
                        Log.w("tst2", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        findViewById<Button>(R.id.registerBtnLogin).setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}