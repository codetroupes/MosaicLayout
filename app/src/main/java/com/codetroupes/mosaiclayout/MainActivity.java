package com.codetroupes.mosaiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.codetroupes.mosaiclayout.lib.listeners.OnItemClickListener;
import com.codetroupes.mosaiclayout.lib.views.BlockPattern;
import com.codetroupes.mosaiclayout.lib.views.MosaicLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MosaicLayout mMosaicLayout;
    private MosaicLayoutAdapter mAdapater;



    BlockPattern.BLOCK_PATTERN pattern1[] = {
            BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL,
            BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL };

    BlockPattern.BLOCK_PATTERN pattern2[] = {
            BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL,
            BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL, BlockPattern.BLOCK_PATTERN.VERTICAL };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMosaicLayout = (MosaicLayout) findViewById(R.id.mosaic_layout);

        // Choose a pattern randomly from the set of pattern specified
        mMosaicLayout.chooseRandomPattern(false);
        mMosaicLayout.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "pos " + position, Toast.LENGTH_LONG).show();
            }
        });
        randomAllPatters();
        // Download images for
        downloadImages();
    }

    private void downloadImages() {
        mMosaicLayout.reset();
        // Set the data to the adapter
        mAdapater = new MosaicLayoutAdapter(getApplicationContext());
        // add the results 2 times to increase the size of the results

        List<Image> values = new ArrayList<>();
//        for (int i =1;i<52;i++){
//            Image image = new Image();
//            image.setTbUrl("https://pic.ilemiss.net/298/"+i+".jpg");
//            values.add(image);
//        }
//        for (int i =1;i<45;i++){
//            Image image = new Image();
//            image.setTbUrl("https://pic.ilemiss.net/1159/"+i+".jpg");
//            values.add(image);
//        }
//        for (int i =1;i<42;i++){
//            Image image = new Image();
//            image.setTbUrl("https://pic.ilemiss.net/1589/"+i+".jpg");
//            values.add(image);
//        }
        for (int i =1;i<18;i++){
            Image image = new Image();
            image.setTbUrl("https://pic.ilemiss.net/1560/"+i+".jpg");
            values.add(image);
        }
//        for (int i =1;i<22;i++){
//            Image image = new Image();
//            image.setTbUrl("https://pic.ilemiss.net/3064/"+i+".jpg");
//            values.add(image);
//        }
        mAdapater.setData(values);
        // Set the adapter to the layout
        mMosaicLayout.setAdapter(mAdapater);
    }

    private void addImages2() {
        mMosaicLayout.reset();
        List<Image> values = new ArrayList<>();
        for (int i =1;i<22;i++){
            Image image = new Image();
            image.setTbUrl("https://pic.ilemiss.net/3064/"+i+".jpg");
            values.add(image);
        }
        mAdapater.setData(values);
        mMosaicLayout.setAdapter(mAdapater);
    }

    private void addImages3() {
        mMosaicLayout.reset();
        List<Image> values = new ArrayList<>();
        for (int i =1;i<44;i++){
            Image image = new Image();
            image.setTbUrl("https://pic.ilemiss.net/1168/"+i+".jpg");
            values.add(image);
        }
        mAdapater.setData(values);
        mMosaicLayout.setAdapter(mAdapater);
    }


    private void randomAllPatters() {
        mMosaicLayout.chooseRandomPattern(true);

    }

    private void randomSelectedPatterns() {
        mMosaicLayout.addPattern(pattern1);
        mMosaicLayout.addPattern(pattern2);
        mMosaicLayout.chooseRandomPattern(true);

    }

    private void orderedSelectedPatterns() {
        mMosaicLayout.addPattern(pattern1);
        mMosaicLayout.addPattern(pattern2);
        mMosaicLayout.chooseRandomPattern(false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action1:
                randomAllPatters();
                break;
            case R.id.action2:
                randomSelectedPatterns();
                break;
            case R.id.action3:
                orderedSelectedPatterns();
                break;
            default:
                randomAllPatters();
                break;
        }
        downloadImages();
        return true;
    }
}
