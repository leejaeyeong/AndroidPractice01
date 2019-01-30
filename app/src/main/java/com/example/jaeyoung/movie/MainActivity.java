package com.example.jaeyoung.movie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    boolean thumbUpState = false;
    boolean thumbDownState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String item[] = { "안녕1" , "안녕2", "안녕3" };
        ListAdapter adapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,item);
        //ListAdapter adapter = new ArrayAdapter<String> (this,R.layout.items,item);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);





        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                // 8. 클릭한 아이템의 문자열을 가져와서
                String selected_item = (String)adapterView.getItemAtPosition(position);

                // 9. 해당 아이템을 ArrayList 객체에서 제거하고
              // list.remove(selected_item);

                // 10. 어댑터 객체에 변경 내용을 반영시켜줘야 에러가 발생하지 않습니다.
                //adapter.notifyDataSetChanged();
            }
        });




        final TextView ratingScoreTextView = findViewById(R.id.ratingtv);
        RatingBar rb = findViewById(R.id.ratingBar1);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingScoreTextView.setText("" + rating);
            }
        });

        final ImageView thumbUpImage = findViewById(R.id.imageView3);
        final ImageView thumbDownImage = findViewById(R.id.imageView4);
        final TextView upCount = findViewById(R.id.thumb_up_count);
        final TextView downCount = findViewById(R.id.thumb_down_count);


        thumbUpImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thumbUpCount = Integer.parseInt(upCount.getText().toString());
                int thumbDownCount = Integer.parseInt(downCount.getText().toString());

                if(checkThumbState() == 1) {    // 업
                    upCount.setText(""+ --thumbUpCount);
                }
                else if(checkThumbState() == 2) {       // 다운
                    upCount.setText(""+ ++thumbUpCount);
                    downCount.setText((""+ --thumbDownCount));
                }
                else {      // 아무것도
                    upCount.setText(""+ ++thumbUpCount);
                }

                if(thumbUpState) {
                    thumbUpImage.setImageResource(R.drawable.ic_thumb_up);
                    thumbUpState = false;
                    thumbDownState = false;

                }
                else {
                    thumbUpImage.setImageResource(R.drawable.ic_thumb_up_selected);
                    thumbDownImage.setImageResource(R.drawable.ic_thumb_down);
                    thumbUpState = true;
                    thumbDownState = false;

                }

            }
        });

        thumbDownImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int thumbUpCount = Integer.parseInt(upCount.getText().toString());
                int thumbDownCount = Integer.parseInt(downCount.getText().toString());

                if(checkThumbState() == 1) {    // 업
                    upCount.setText(""+ --thumbUpCount);
                    downCount.setText((""+ ++thumbDownCount));
                }
                else if(checkThumbState() == 2) {       // 다운
                    downCount.setText((""+ --thumbDownCount));
                }
                else {      // 아무것도
                    downCount.setText(""+ ++thumbDownCount);
                }


                if(thumbDownState) {
                    thumbDownImage.setImageResource(R.drawable.ic_thumb_down);
                    thumbDownState = false;
                    thumbUpState = false;

                }
                else {
                    thumbDownImage.setImageResource(R.drawable.ic_thumb_down_selected);
                    thumbUpImage.setImageResource(R.drawable.ic_thumb_up);
                    thumbDownState = true;
                    thumbUpState = false;

                }
            }
        });

    }
    // 이미지 클릭 시 이벤트 처리 추가
    //

    public int checkThumbState() {
        if(thumbUpState == true && thumbDownState == false) return 1;
        else if(thumbUpState == false && thumbDownState == true) return 2;
        else return 3;
    }

    public void onButtonClicked(View v) {
        ImageView imageview = (ImageView) findViewById(R.id.imageView3);

        imageview.setImageResource(R.drawable.ic_thumb_up_selected);
        Toast.makeText(getApplicationContext(), "버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/m.naver.com"));
        startActivity(intent);
    }
}
