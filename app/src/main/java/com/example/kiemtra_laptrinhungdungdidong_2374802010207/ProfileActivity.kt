package com.example.kiemtra_laptrinhungdungdidong_2374802010207

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Nhận dữ liệu Email từ Intent Bundle
        val email = intent.getStringExtra("USER_EMAIL") ?: ""
        tvUserEmail.text = "Email: $email"

        // Xử lý nút Đăng xuất (Đóng màn hình hiện tại để quay về Login)
        btnLogout.setOnClickListener {
            finish()
        }
    }
}