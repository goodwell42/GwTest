package com.example.gwtest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FisrtActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", this.toString());
        // 调用first_layout
        setContentView(R.layout.first_layout);
        // 设置Toast
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FisrtActivity.this,"You clicked Button 1,hello goodwell",
                //        Toast.LENGTH_SHORT).show();
                // 显式intent意图：在first基础上打开second，上下文加指定
                // Intent intent = new Intent(FisrtActivity.this, SecondActivity.class);
                // 隐式intent
                // Intent intent = new   Intent("com.example.activitytest.ACTION_START");
                // intent.addCategory("com.example.activitytest.MY_CATEGORY");
                // 浏览器
                // Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(Uri.parse("https://goodwell42.github.io"));
                // 电话
                // Intent intent = new Intent(Intent.ACTION_DIAL);
                // intent.setData(Uri.parse("tel:18975251274"));
                // 用putExtra向下一个活动传递数据
                // String data = "Hello SecondActivity,goodwell";
                // Intent intent = new Intent(FisrtActivity.this, SecondActivity.class);
                // intent.putExtra("extra_data", data);
                // startActivityForResult返回数据给上一个活动
                // Intent intent = new Intent(FisrtActivity.this, SecondActivity.class);
                //startActivityForResult(intent, 1);
                // startActivity(intent);2
                Intent intent = new Intent(FisrtActivity.this, FisrtActivity.class);
                startActivity(intent);
            }
        });
    }
    // 创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    // 定义菜单响应事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FisrtActivity", returnedData);
                }
                break;
            default:
        }
    }
}
