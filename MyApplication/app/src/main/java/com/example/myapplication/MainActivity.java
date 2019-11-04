package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button b1;
    public final int CODE_ACTIVITY2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String texto = "onCreate() o lo que quieras";
        // Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
        b1= findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //  Toast.makeText(MainActivity.this,"he cliucad el boton listener\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (MainActivity.this, Main2Activity.class);
                intent.putExtra("edad",10);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        String texto = "onStart()";
        // Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        String texto = "onResume()";
        //Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        String texto = "onPause()";
        //Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        String texto = "onRestart()";
        //Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        String texto = "onStop()";
        //Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        String texto = "onDestroy()";
        //Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    public void irActivity2(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        finish();//Esto hace que la anterior pestaña, mainactivity, se cierre y no se quede guardada en pila
    }
    public void ChangeActivityForResult(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("clase","no va");
        startActivityForResult(intent,CODE_ACTIVITY2);//le pasamos info y esperamos resultado
        //finish();//Esto hace que la anterior pestaña, mainactivity, se cierre y no se quede guardada en pila
    }

    public void clickButton1(View view) {
        Toast.makeText(this,"He clicado el boton lol",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //NO VA Y NPO CONSIGO SABER POR QUE
        super.onActivityResult(requestCode,resultCode,data);
        Toast.makeText(this,"no if",Toast.LENGTH_SHORT).show();

        if (requestCode==CODE_ACTIVITY2){

            if (resultCode==RESULT_OK){
                Bundle extras = data.getExtras();

                if(extras!=null){
                    Toast.makeText(this,extras.getString("clase"),Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
