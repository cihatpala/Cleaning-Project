package com.example.pala.senatemizlik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
        signIn = findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "login";
                String user_name,password,repassword,nick_name;
                user_name=userName.getText().toString();
                password=pass.getText().toString();
                repassword=passRe.getText().toString();
                nick_name=nickName.getText().toString();
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
                BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                backgroundWorker.execute(type,nick_name,password);

            }
        });


    }
}
