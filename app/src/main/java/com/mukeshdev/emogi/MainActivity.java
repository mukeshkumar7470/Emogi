package com.mukeshdev.emogi;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {

    EditText etEmoji;
    LinearLayout llTextViews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmoji = findViewById(R.id.etEmoji);
        llTextViews = findViewById(R.id.llTextViews);

        final EmojiPopup popup = EmojiPopup.Builder
                .fromRootView(findViewById(R.id.rootView)).build(etEmoji);

        ImageView btnEmojis=findViewById(R.id.btnEmojis);
        btnEmojis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.toggle();
            }
        });

        ImageView btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llTextViews.addView(getEmojiTextView());
                etEmoji.getText().clear();
            }
        });


    }

    private EmojiTextView getEmojiTextView() {
        EmojiTextView tvEmoji = (EmojiTextView) LayoutInflater
                .from(getApplicationContext())
                .inflate(R.layout.emogi_text_view, llTextViews,false);
        tvEmoji.setText(etEmoji.getText().toString());
        return tvEmoji;
    }
}