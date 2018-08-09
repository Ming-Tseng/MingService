package tw.org.cmtseng.mingservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ChatService extends Service {
    public ChatService() {
    }

    private static final String TAG = "vanessa";
    
    public class ChatBinder extends Binder {
            public ChatService getService(){
                return ChatService.this;
            }
    }

    ChatBinder mBinder = new ChatBinder();
    
    @Override
    public IBinder onBind(Intent intent) {
        //  Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }
    
    public void  sendMessage(String message){
        Log.d(TAG, "sendMessage: " + message);
    }
    public void  deleteMessage(){
        Log.d(TAG, "deleteMessage: ");
    }
}
