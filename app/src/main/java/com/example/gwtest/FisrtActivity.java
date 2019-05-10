package com.example.gwtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FisrtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                // Intent intent = new Intent("com.example.activitytest.ACTION_START");
                // intent.addCategory("com.example.activitytest.MY_CATEGORY");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://goodwell42.github.io"));
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
}
