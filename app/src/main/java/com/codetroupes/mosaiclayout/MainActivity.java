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
            BlockPattern.BLOCK_PATTERN.SMALL,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.SMALL,
            BlockPattern.BLOCK_PATTERN.SMALL,
            BlockPattern.BLOCK_PATTERN.SMALL,
            BlockPattern.BLOCK_PATTERN.HORIZONTAL,
            BlockPattern.BLOCK_PATTERN.VERTICAL,
            BlockPattern.BLOCK_PATTERN.VERTICAL };

    BlockPattern.BLOCK_PATTERN pattern2[] = {
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG,
            BlockPattern.BLOCK_PATTERN.BIG };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMosaicLayout = (MosaicLayout) findViewById(R.id.mosaic_layout);
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
        for (int i =0;i<30;i++){
            Image image = new Image();
            if(i%2==0){
                image.setTbUrl("https://hbimg.huabanimg.com/611acfd42f4b175c280853e0b427cf1ff8f12f873a1d2-ejFBym_fw658");
            }else{
                image.setTbUrl("https://hbimg.huabanimg.com/683ffbbb3b7b407f7779ca37cf338f1f13d028062f14d9-2pUG2V_fw658");
            }
            values.add(image);
        }

        mAdapater.setData(values);
        // Set the adapter to the layout
        mMosaicLayout.setAdapter(mAdapater);
    }


    private void randomSelectedPatterns() {
        mMosaicLayout.reset();
        mMosaicLayout.addPattern(pattern1);
//        mMosaicLayout.addPattern(pattern2);
        mMosaicLayout.chooseRandomPattern(true);

    }


    private void randomAllPatters() {
        mMosaicLayout.reset();
        mMosaicLayout.chooseRandomPattern(true);
    }



    private void orderedSelectedPatterns() {
        mMosaicLayout.reset();
        mMosaicLayout.addPattern(pattern1);
//        mMosaicLayout.addPattern(pattern2);
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
            case R.id.action2:
                randomSelectedPatterns();
            case R.id.action3:
                orderedSelectedPatterns();
            default:
                randomAllPatters();
        }
        downloadImages();
        return true;
    }
}
