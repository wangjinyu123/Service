package com.example.administrator.servicesdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button startBtn,stopBtn,bindBtn,unbindBtn,intentService,toActivity2;
    MyService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder=(MyService.MyBinder)iBinder;
            myBinder.startOne();
            myBinder.stopOne();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void init(){
        startBtn=findViewById(R.id.startService);
        stopBtn=findViewById(R.id.stopService);
        bindBtn=findViewById(R.id.bindService);
        unbindBtn=findViewById(R.id.unbindService);
        intentService=findViewById(R.id.intentService);
        toActivity2=findViewById(R.id.to_activity2);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        intentService.setOnClickListener(this);
        toActivity2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startService:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stopService:
                Intent stopIntent=new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bindService:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);

                break;
            case R.id.unbindService:
                unbindService(connection);
                break;
            case R.id.intentService:
                Intent intent=new Intent(this,MyIntentService.class);
                startService(intent);
                break;
            case R.id.to_activity2:
                Intent intent1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent1);
                MainActivity.this.finish();
                break;
        }
    }
}
