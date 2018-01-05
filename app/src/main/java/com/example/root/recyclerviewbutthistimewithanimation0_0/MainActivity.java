package com.example.root.recyclerviewbutthistimewithanimation0_0;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.SimpleAdapter;

import com.example.root.recyclerviewbutthistimewithanimation0_0.Adapter.RecyclerSimpleAdapter;

public class MainActivity extends AppCompatActivity {
Button btnFallDown,btnSlidefromBottom,btnslideFromRight;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFallDown=findViewById(R.id.btnFallDown);
        recyclerView=findViewById(R.id.recyclerView);
        btnSlidefromBottom=findViewById(R.id.btnSlide);
        btnslideFromRight=findViewById(R.id.btnRightSlide);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnFallDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView,0);
            }
        });
        btnSlidefromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView,1);

            }
        });
        btnslideFromRight.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     runAnimation(recyclerView,2);
                                                 }
                                             }

        );
    }
private void runAnimation(RecyclerView recyclerView,int type){
    Context context=recyclerView.getContext();
    LayoutAnimationController controller=null;
    if(type==0) // FallDown
        controller= AnimationUtils.loadLayoutAnimation(this,R.anim.layout_fall_down);

   else if (type==1)controller=AnimationUtils.loadLayoutAnimation(this,R.anim.layout_slide_from_bottom);
else controller=AnimationUtils.loadLayoutAnimation(this,R.anim.layout_slide_right);

        RecyclerSimpleAdapter adapter= new RecyclerSimpleAdapter();
        recyclerView.setAdapter(adapter);
        //Set Anim
    recyclerView.setLayoutAnimation(controller);
    recyclerView.getAdapter().notifyDataSetChanged();
    recyclerView.scheduleLayoutAnimation();

    }
}
