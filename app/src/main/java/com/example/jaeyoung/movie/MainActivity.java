package com.example.jaeyoung.movie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView ratingScoreTextView = findViewById(R.id.ratingtv);
        RatingBar rb = findViewById(R.id.ratingBar1);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratingScoreTextView.setText(""+rating);
            }
        });
    }
    // 이미지 클릭 시 이벤트 처리 추가
    //
    public void onButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌렸습니다." , Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/m.naver.com"));
        startActivity(intent);
    }
}
