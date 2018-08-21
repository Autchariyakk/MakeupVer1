package com.autchariya.kiklik.makeuptutorial4.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.autchariya.kiklik.makeuptutorial4.R;
import com.zomato.photofilters.FilterPack;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.utils.ThumbnailCallback;
import com.zomato.photofilters.utils.ThumbnailItem;
import com.zomato.photofilters.utils.ThumbnailsManager;

import java.util.List;

public class FillterImageActivity extends AppCompatActivity implements ThumbnailCallback {
    static {
        System.loadLibrary("NativeImageProcessor");
    }
    private Activity activity;
    private RecyclerView thumbListView;
    private ImageView placeHolderImageView;
//    int drawable;
    private String path;
//    private ImageView imageView;
    private  Drawable drawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillter_image);
        Log.i("imv", "Show");

        placeHolderImageView = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        path = bundle.getString("path");
        Log.i("path", path);
        drawable = Drawable.createFromPath(path);

//        try {
//            InputStream inputStream = getContentResolver().openInputStream(Uri.fromFile(new File(path)));
//            drawable = Drawable.createFromStream(inputStream, path );
//            imageView.setImageDrawable(drawable);
//        } catch (FileNotFoundException e) {
//            drawable = getResources().getDrawable(R.drawable.ic_action_camera);
//            imageView.setImageDrawable(drawable);
//        }


        initUIWidgets();
    }

    private void initUIWidgets() {
        thumbListView = (RecyclerView) findViewById(R.id.thumbnails);
        placeHolderImageView = (ImageView) findViewById(R.id.imageView);
        placeHolderImageView.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(path), 640, 640, false));
        initHorizontalList();
    }

    private void initHorizontalList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        thumbListView.setLayoutManager(layoutManager);
        thumbListView.setHasFixedSize(true);
        bindDataToAdapter();
    }

    private void bindDataToAdapter() {
        final Context context = this.getApplication();
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                Bitmap thumbImage = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(path), 640, 640, false);
                ThumbnailsManager.clearThumbs();
                List<Filter> filters = FilterPack.getFilterPack(getApplicationContext());

                for (Filter filter : filters) {
                    ThumbnailItem thumbnailItem = new ThumbnailItem();
                    thumbnailItem.image = thumbImage;
                    thumbnailItem.filter = filter;
                    ThumbnailsManager.addThumb(thumbnailItem);
                }

                List<ThumbnailItem> thumbs = ThumbnailsManager.processThumbs(context);

                ThumbnailsAdapter adapter = new ThumbnailsAdapter(thumbs, getThumbnailCallback());
                thumbListView.setAdapter(adapter);

                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    private ThumbnailCallback getThumbnailCallback(){
        return this;
    }

    @Override
    public void onThumbnailClick(Filter filter) {
        placeHolderImageView.setImageBitmap(filter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(path), 640, 640, false)));
    }
}

