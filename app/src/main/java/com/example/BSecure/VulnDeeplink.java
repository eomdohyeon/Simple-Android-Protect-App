package com.example.BSecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.BSecure.R;

public class VulnDeeplink extends AppCompatActivity {

    private Button btn_uri_link;
    private Button btn_app_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuln_deeplink);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        // web_uri=http://www.baselinesecu.co.kr&app_uri=market://launch?id=com.nhn.android.webtoon
        String web_uri = data.getQueryParameter("web_uri");
        String app_uri = data.getQueryParameter("app_uri");

        btn_uri_link = findViewById(R.id.btn_uri_link);
        btn_app_link = findViewById(R.id.btn_app_link);

        btn_uri_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srchString = app_uri;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(srchString));
                intent.setPackage("com.android.vending");
                startActivity(intent);
//                finish();
            }
        });

        btn_app_link.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String srchString = web_uri;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(srchString));
                intent.setPackage("com.sec.android.app.sbrowser");
                startActivity(intent);
//                finish();
            }
        });
    }

}