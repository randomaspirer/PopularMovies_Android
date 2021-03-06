package com.example.nandeesh_randomaspirer.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    
    public static final String IMAGE_URL_EXTRA = "imgurl",
                                TITLE_EXTRA = "title",
                                RATING_EXTRA = "rating",
                                RELEASE_DATE_EXTRA = "releasedate",
                                SYNOPSIS_EXTRA = "synopsis";
    
    ImageView mPoster;
    TextView mtitle, mrating, mreleasedate, msynopsis;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mPoster = (ImageView) findViewById(R.id.poster_iv);
        mtitle = (TextView) findViewById(R.id.title_tv);
        mrating = (TextView) findViewById(R.id.rating_tv);
        mreleasedate = (TextView) findViewById(R.id.releasedate_tv);
        msynopsis = (TextView) findViewById(R.id.synopsis_tv);
        
        
        Intent Detail_intent = this.getIntent();
        
        String base_img_url = "http://image.tmdb.org/t/p/";
        String img_size = "w500";
        if (Detail_intent != null && Detail_intent.hasExtra("title")) {
            String img_path = Detail_intent.getStringExtra(IMAGE_URL_EXTRA);
            // String img_path = Detail_intent.getStringExtra("backdrop");
            
            
            Picasso.with(this).load(base_img_url + img_size + img_path).into(mPoster);
            mtitle.setText("Movie: " + Detail_intent.getStringExtra(TITLE_EXTRA));
            mrating.setText("Rating: " + (Detail_intent.getDoubleExtra(RATING_EXTRA, 0.0)));
            
            mreleasedate.setText("Release Date: " + (Detail_intent.getStringExtra(RELEASE_DATE_EXTRA)));
            msynopsis.setText("Plot Overview: " + Detail_intent.getStringExtra(SYNOPSIS_EXTRA));
            
        }
        
        
    }
    
}
