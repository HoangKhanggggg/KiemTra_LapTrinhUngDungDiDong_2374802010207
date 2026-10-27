package com.example.kiemtra_laptrinhungdungdidong_2374802010207

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View bằng findViewById theo yêu cầu đề bài
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 1. Kiểm tra bỏ trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Email hoặc Mật khẩu không được để trống!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "Email sai định dạng!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 3. Kiểm tra độ dài mật khẩu (< 6 ký tự)
            if (password.length < 6) {
                tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 4. Hợp lệ hoàn toàn
            tvStatus.text = "Xác thực thành công!"
            tvStatus.setTextColor(Color.parseColor("#4CAF50"))
        }
    }
}