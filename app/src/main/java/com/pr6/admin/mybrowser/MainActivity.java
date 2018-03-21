package com.pr6.admin.mybrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView brow;
    EditText urledit;
    Button go,forward,back,clear,reload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brow=(WebView)findViewById(R.id.wv_brow);
        urledit=(EditText)findViewById(R.id.et_url);
        go=(Button)findViewById(R.id.btn_go);
        forward=(Button)findViewById(R.id.btn_fwd);
        back=(Button)findViewById(R.id.btn_bck);
        clear=(Button)findViewById(R.id.btn_clear);
        reload=(Button)findViewById(R.id.btn_reload);

        brow.setWebViewClient(new ourViewClient());
        WebSettings webSettings=brow.getSettings();
        webSettings.setJavaScriptEnabled(true);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editextvalue=urledit.getText().toString();
                if(!editextvalue.startsWith("http://"))
                    editextvalue= "http://"+editextvalue;

                brow.loadUrl(editextvalue);


                InputMethodManager imm  = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(urledit.getWindowToken(),0);
            }
        });


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(brow.canGoForward()){
                    brow.goForward();

                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(brow.canGoBack()){
                    brow.goBack();
                }

            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                brow.reload();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                brow.clearHistory();
            }
        });


    }
}
