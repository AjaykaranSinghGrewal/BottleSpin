package grewal.example.ajayk.bottlespin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button mButtonSpin;
    ImageView mImageViewBottle;
    Random mRandom = new Random();

    boolean goAgain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonSpin = (Button) findViewById(R.id.btnSpin);
        mImageViewBottle = (ImageView) findViewById(R.id.imageViewBottle);

        mButtonSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bottleAngle = mRandom.nextInt()+360;
                RotateAnimation rotateAnimation = new RotateAnimation(0, bottleAngle, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                mImageViewBottle.startAnimation(rotateAnimation);
                changeBtnName();
            }
        });
    }

    private void changeBtnName() {
        if(goAgain){
            mButtonSpin.setText("SPIN");
            goAgain=true;
        }
        else{
            mButtonSpin.setText("SPIN AGAIN");
        }
    }
}
