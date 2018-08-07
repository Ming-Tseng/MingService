package tw.org.cmtseng.mingservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;



public class MyService extends Service {
    private static final String TAG = "vanessa";
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand: ");
        Log.d(TAG, "onStartCommand: 下載檔案中...");
        new Handler().postDelayed(  //在此需加入Runnable()
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "下載完成");
                    }
                }
                , 3000);
        
        return  super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
//         Return the communication channel to the service.
//         throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}
