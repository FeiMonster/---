package monster.com.mybroadcastlogin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ASUS on 2017/3/7.
 */

public class BaseActivity extends AppCompatActivity {
    private  ForceOffLineRecevier recevier;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("monster.com.broadcastbestpractice.FORCE_OFFLINE");
        recevier = new ForceOffLineRecevier();
        registerReceiver(recevier,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    class ForceOffLineRecevier extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("下线提醒").setMessage("您的账号在别处登录，请您重新登录").setCancelable(false);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finshAll();
                    Intent i = new Intent(context,MainActivity.class);
                    context.startActivity(i);
                }
            });
            builder.show();
        }
    }
}
