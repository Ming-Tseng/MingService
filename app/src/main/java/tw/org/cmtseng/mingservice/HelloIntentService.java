package tw.org.cmtseng.mingservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.text.format.DateFormat;



public class HelloIntentService extends IntentService {
    public static final String  PARAM_MSG = "message";
    public static final String  TAG = "vanessa";

    public HelloIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String msg = intent.getStringExtra(PARAM_MSG);
        Log.d(TAG, "onHandleIntent: ");
        SystemClock.sleep(3000);
//      String debug = DateFormat.format("hh:mm:ss", System.currentTimeMillis()+"\t"+ msg);
        String debug = DateFormat.format("hh:mm:ss", System.currentTimeMillis()) + "\t" + msg;
        Log.d(TAG, debug);
    }
}
