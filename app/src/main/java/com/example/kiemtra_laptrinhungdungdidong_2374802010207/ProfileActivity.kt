package com.example.kiemtra_laptrinhungdungdidong_2374802010207

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Nhận dữ liệu Email từ Intent Bundle
        val email = intent.getStringExtra("USER_EMAIL") ?: ""
        tvUserEmail.text = "Email: $email"

        // Xử lý nút Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }

        // Khởi tạo danh sách mẫu (Ít nhất 5 phần tử)
        val subjects = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Gắn ArrayAdapter với layout mẫu đơn giản
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // Bắt sự kiện Click chọn item trong ListView hiển thị Toast
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val selectedSubject = subjects[position]
            Toast.makeText(this, selectedSubject, Toast.LENGTH_SHORT).show()
        }
    }
}