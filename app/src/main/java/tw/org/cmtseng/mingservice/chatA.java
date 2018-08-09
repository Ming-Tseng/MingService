package tw.org.cmtseng.mingservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class chatA extends AppCompatActivity implements ServiceConnection {

    private static final String TAG ="vanessa" ;
    ChatService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
//        Log.d(TAG, "onCreate: chatA");
        Intent chatS = new Intent(this,ChatService.class);
        bindService(chatS, this, BIND_AUTO_CREATE);
    }


    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ChatService.ChatBinder binder = (ChatService.ChatBinder) iBinder;
        mService = binder.getService();
        Log.d(TAG, "onServiceConnected: CharService binded ");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mService = null;
        Log.d(TAG, "onServiceDisconnected: CharService unbinded");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, ChatService.class);
        bindService(intent, this, BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    public void send(View v){
        Log.d(TAG, "send: ");
        EditText ed = (EditText)findViewById(R.id.ed_message);
        String msg = ed.getText().toString();
        if (mService!=null){
            mService.sendMessage(msg);
        }
    }
}
