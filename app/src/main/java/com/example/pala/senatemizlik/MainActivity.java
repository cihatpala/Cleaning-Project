package com.example.pala.senatemizlik;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    EditText userName,nickName,pass,passRe;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.app_logo);
        image.setImageResource(R.drawable.logo);
        userName=findViewById(R.id.user_name);
        nickName=findViewById(R.id.nick_name);
        pass = findViewById(R.id.pass);
        passRe = findViewById(R.id.re_pass);
        signIn = findViewById(R.id.btnLogin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = userName.getText().toString();
                String password = pass.getText().toString();
                String repassword = passRe.getText().toString();
                String nick_name = nickName.getText().toString();
                try{
                    if (user_name.equals("") || password.equals("") || repassword.equals("") || nick_name.equals("")){
                        Toast.makeText(MainActivity.this, "Lütfen boş alan bırakmayınız.",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        if (password.equals(repassword)){
                            Toast.makeText(MainActivity.this, "Kaydınız başarıyla tamamlandı. ",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "Hoşgeldiniz Sayın "+user_name,
                                    Toast.LENGTH_SHORT).show();
                        }else{Toast.makeText(MainActivity.this, "Şifreniz aynı olmak zorundadır.",
                                Toast.LENGTH_SHORT).show();}
                    }
                }catch(Exception ex){
                    Toast.makeText(MainActivity.this, ex+"Hatası ile karşılaşıldı.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
