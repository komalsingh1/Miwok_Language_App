package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә",R.mipmap.family_father,R.raw.family_father));
        words.add(new Word("mother", "әṭa",R.mipmap.family_mother,R.raw.family_mother));
        words.add(new Word("son", "angsi",R.mipmap.family_son,R.raw.family_son));
        words.add(new Word("daughter", "tune",R.mipmap.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother", "taachi",R.mipmap.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti",R.mipmap.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe",R.mipmap.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti",R.mipmap.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother ", "ama",R.mipmap.family_grandmother,R.raw.family_grandmother));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getmAudioResourcceId());
                mMediaPlayer.start();
            }
        });
    }
}