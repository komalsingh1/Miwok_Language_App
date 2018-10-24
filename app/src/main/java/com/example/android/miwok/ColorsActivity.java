package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi",R.mipmap.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.mipmap.color_dusty_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә", R.mipmap.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("green", "chokokki",R.mipmap.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.mipmap.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.mipmap.color_gray,R.raw.color_green));
        words.add(new Word("black", "kululli",R.mipmap.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.mipmap.color_white,R.raw.color_white));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word= words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getmAudioResourcceId());
                mMediaPlayer.start();
            }
        });
    }
}