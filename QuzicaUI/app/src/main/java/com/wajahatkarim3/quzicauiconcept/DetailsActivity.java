package com.wajahatkarim3.quzicauiconcept;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.BinderThread;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    public final String TAG = DetailsActivity.class.getSimpleName();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.txtName_details) TextView txtName;
    @BindView(R.id.txtHandle_details) TextView txtHandle;
    @BindView(R.id.imgPic_details) ImageView imgPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTransionsAnimations();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setTransionsAnimations()
    {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            //Transition transition = getWindow().getSharedElementEnterTransition();
        }
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        Log.e(TAG, "onEnterAnimationComplete: " );

        // Pic, name, handle
        ViewAnimator
                .animate(imgPic)
                    .alpha(0.2f,1)
                    .translationX(-20,0)
                    .translationY(20,0)
                    .duration(200)
                .andAnimate(txtName)
                    .alpha(0.0f,1f)
                    .translationX(30, 0)
                    .duration(300)
                    .startDelay(100)
                .andAnimate(txtHandle)
                    .alpha(0.0f,1f)
                    .translationX(50, 0)
                    .duration(300)
                    .startDelay(200)
                .start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                endActivity();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void endActivity()
    {
        ViewAnimator
                .animate(imgPic)
                    .alpha(1,0.2f)
                    .translationX(0,-20)
                    .translationY(0,20)
                    .duration(200)
                .andAnimate(txtName)
                    .alpha(1f,0f)
                    .translationX(0, 30)
                    .duration(300)
                    .startDelay(100)
                .andAnimate(txtHandle)
                    .alpha(1f,0f)
                    .translationX(0, 50)
                    .duration(300)
                    .startDelay(200)
                .onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            supportFinishAfterTransition();
                        } else {
                            finish();
                        }
                    }
                })
                .start();
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        endActivity();
    }
}
