package com.example.andrometrixlite.SpinWheel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;


import com.anupkumarpanwar.scratchview.ScratchView;
import com.example.andrometrixlite.R;

import java.util.Random;

public class SpinWheelActivity extends AppCompatActivity {
    ImageView spin;
    private static final String [] sectors ={"10$","Zero","2$","50$","1$","5$","20$","Jackpot","15$","100$","1$","5$"};
    private static final int [] sectorDegrees = new int[sectors.length];
    private static final int [] spin_result={0,1,3,4,5,6,7,9,10,11};
    private static final Random random =new Random();
    private int degree =0;
    private boolean isSpinning =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_wheel);

        spin =findViewById(R.id.spin_wheel2);
        getDegreeForSectores();


        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSpinning){
                    spin_wheel();
                    isSpinning=true;

                }

            }
        });
    }

    private void spin_wheel() {

        degree =spin_result[random.nextInt(9)];
        //degree =random.nextInt(sectors.length-1);
        RotateAnimation rotateAnimation =new RotateAnimation(0,(360* sectors.length)+sectorDegrees[degree],
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (degree==4){
                    Dialog dialog =new Dialog(SpinWheelActivity.this);
                    dialog.setContentView(R.layout.popup_jackpot);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    ScratchView scratchView = dialog.findViewById(R.id.scratchview);
                    scratchView.setRevealListener(new ScratchView.IRevealListener() {
                        @Override
                        public void onRevealed(ScratchView scratchView) {

                            Toast.makeText(SpinWheelActivity.this, "you got design course free", Toast.LENGTH_SHORT).show();
//                            Intent intent =new Intent(MainActivity2.this,MainActivity3.class);
//                            startActivity(intent);
                        }

                        @Override
                        public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {

                        }
                    });
                    dialog.show();
//                    Intent intent =new Intent(MainActivity2.this,JackpotActivity.class);
//                    startActivity(intent);
                }
                isSpinning =false;
                Toast.makeText(SpinWheelActivity.this,"You Got "+sectors[sectors.length-(degree+1)]+"Points",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        spin.startAnimation(rotateAnimation);
    }

    private void getDegreeForSectores(){
        int sectorDegree =360/sectors.length;
//        for (int i=0;i < sectors.length ;i++){
//            sectorDegrees[i] = (i+1) * sectorDegree;
//        }
        int j;
        for ( j=0;j < 2;j++){
            sectorDegrees[j] = (j+1) * sectorDegree;
        }
        sectorDegrees[2] = 2* sectorDegree;
        for (j=3;j<8;j++){
            sectorDegrees[j] = (j+1) * sectorDegree;
        }
        sectorDegrees[8] = 8* sectorDegree;
        for (j=9;j<sectors.length;j++){
            sectorDegrees[j] = (j+1) * sectorDegree;
        }
    }

}