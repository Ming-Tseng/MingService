package tw.org.cmtseng.mingservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MyService.class );

        switch(view.getId()) {
            case  R.id.btn_startServcie:
                startService(intent);
                break;
            case  R.id.btn_stopService:
                stopService(intent);
                break;
            case  R.id.btn_helloservice:
                break;
        }

    }
}
