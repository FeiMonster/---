package monster.com.mybroadcastlogin;

import android.content.Intent;
import android.os.health.PackageHealthStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private EditText edt_account;
    private  EditText edt_psw;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_psw = (EditText) findViewById(R.id.edt_psw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edt_account.getText().toString();
                String password = edt_psw.getText().toString();
                if(account.equals("Monster") && password.equals("123")){
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
