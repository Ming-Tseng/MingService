package tw.org.cmtseng.mingservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Service mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildview();
    }

    private void buildview() {
        //btn
        findViewById(R.id.btn_startServcie).setOnClickListener(this);
        findViewById(R.id.btn_stopService).setOnClickListener(this);
        findViewById(R.id.btn_helloservice).setOnClickListener(this);
        findViewById(R.id.btn_chat).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MyService.class );
        Intent hello  = new Intent(this,HelloIntentService.class );
//        Intent chatA  = new Intent(this,chatA.class );
        switch(view.getId()) {
            case  R.id.btn_startServcie:
                startService(intent);
                break;
            case  R.id.btn_stopService:
                stopService(intent);
                break;
            case  R.id.btn_helloservice:
                hello.putExtra(HelloIntentService.PARAM_MSG, "TEST1");
                startService(hello);
                hello.putExtra(HelloIntentService.PARAM_MSG, "TEST2");
                startService(hello);
                break;
            case  R.id.btn_chat:
                startActivity(new Intent(this, chatA.class));
                break;
        }

    }

/*     @Override
   public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ChatService.ChatBinder binder = (ChatService.ChatBinder)iBinder;
         mService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mService = null;
    }*/
}
