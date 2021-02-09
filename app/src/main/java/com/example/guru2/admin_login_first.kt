package com.example.guru2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class admin_login_first : AppCompatActivity() {
    lateinit var btnReader :Button
    lateinit var btnRecord :Button
    lateinit var btnAttend : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login_first)
        btnReader = findViewById(R.id.btnCard) //리더기 버튼
        btnAttend = findViewById(R.id.btnPay) //출결확인 버튼
        btnRecord = findViewById(R.id.btnLogout)
        var getId = intent.getStringExtra("getId").toString()
        var getPwd = intent.getStringExtra("getPwd").toString()
        var getAuth = intent.getStringExtra("getAuth").toString()
        var getName = intent.getStringExtra("getName").toString()
        var getDepart = intent.getStringExtra("getDepart").toString()
        var getMajor = intent.getStringExtra("getMajor").toString()
        var getProfile = intent.getStringExtra("getProfile").toString()
        var getDue = intent.getStringExtra("getDue").toString()
        var getReceive = intent.getStringExtra("getReceive").toString()



        //출결확인 버튼
        btnAttend.setOnClickListener {
            if(getAuth =="1"){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("알림!")
                builder.setMessage("출결 확인 권한이 없습니다.")
                builder.setIcon(R.drawable.symbol)
                builder.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                })
                builder.show()
            }else {
                var intent = Intent(this, attend_confirm::class.java)
                intent.putExtra("getId", getId)
                intent.putExtra("getPwd", getPwd)
                intent.putExtra("getAuth", getAuth)
                intent.putExtra("getName", getName)
                intent.putExtra("getMajor", getMajor)
                intent.putExtra("getDepart", getDepart)
                intent.putExtra("getDue",getDue)
                intent.putExtra("getReceive",getReceive)
                intent.putExtra("getProfile",getProfile)
                startActivity(intent)
            }


        }

        btnRecord.setOnClickListener {
            if(getAuth =="1"){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("알림!")
                builder.setMessage("출입 기록 확인 권한이 없습니다.")
                builder.setIcon(R.drawable.symbol)
                builder.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                })
                builder.show()
            }else {
                var intent = Intent(this, access_record::class.java)
                intent.putExtra("getId", getId)
                intent.putExtra("getPwd", getPwd)
                intent.putExtra("getAuth", getAuth)
                intent.putExtra("getName", getName)
                intent.putExtra("getMajor", getMajor)
                intent.putExtra("getDepart", getDepart)
                intent.putExtra("getDue",getDue)
                intent.putExtra("getReceive",getReceive)
                intent.putExtra("getProfile",getProfile)
                startActivity(intent)
            }


        }


        //리더기 버튼
        btnReader.setOnClickListener {

            var intent = Intent(this, nfc_reader::class.java)
            intent.putExtra("getRederId", getId)
            intent.putExtra("getRederPwd", getPwd)
            intent.putExtra("getRederAuth", getAuth)
            intent.putExtra("getRederName", getName)
            intent.putExtra("getRederMajor", getMajor)
            intent.putExtra("getRederDepart", getDepart)
            intent.putExtra("getRederDue",getDue)
            intent.putExtra("getRederReceive",getReceive)
            intent.putExtra("getRederProfile",getProfile)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.admin_login_first,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.Logout-> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}