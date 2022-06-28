package com.nacho.betago.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.nacho.betago.R;
import com.nacho.betago.adapter.FragmentAdapter;
import com.nacho.betago.databinding.ActivityMainBinding;

import static com.nacho.betago.adapter.FragmentAdapter.PAGE_POSITION;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setTabLayout();
        setViewPager();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTabLayout(){

        //어댑터 초기화
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), PAGE_POSITION);
        viewPager = binding.viewPager;//== (viewPager = findViewById(R.id.viewPager);
        //어댑터 연결
        viewPager.setAdapter(adapter);

        tabLayout = binding.tab;//== (tabLayout = findViewById(R.id.tab);
        //ArrayList에 저장된 순서대로 Tab 이름을 지정해줌
        //tabNames.stream().forEach(name ->tabLayout.addTab(tabLayout.newTab().setText(name)));
        tabLayout.setupWithViewPager(viewPager);

        //Tab 아이콘 설정
        tabLayout.getTabAt(0).setIcon(R.drawable.reservation_work);
        tabLayout.getTabAt(0).setText("예매");
        tabLayout.getTabAt(1).setIcon(R.drawable.place);
        tabLayout.getTabAt(1).setText("둘러보기");
        tabLayout.getTabAt(2).setIcon(R.drawable.ticket);
        tabLayout.getTabAt(2).setText("승선권");
        tabLayout.getTabAt(3).setIcon(R.drawable.notification);
        tabLayout.getTabAt(3).setText("알림");
        tabLayout.getTabAt(4).setIcon(R.drawable.mypage);
        tabLayout.getTabAt(4).setText("내 정보");

        //Tab 아이콘 색상 초기화 (맨 처음 화면일때의 Tab 아이콘 색상 설정)
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
    }

    private void setViewPager() {

        //페이지 리스너 (viewPager와 TabLayout의 페이지를 맞춰줌)
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //탭 선택 리스너 (탭 행동 설정)
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //선택된 탭일 때
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //선택된 탭과 연결된 fragment를 가져옴
                viewPager.setCurrentItem(tab.getPosition(),false);
                //아이콘 색상을 흰색으로 설정

                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.drawable.reservation_work);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.place_work);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ticket_work);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.notification_work);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 4:
                        tab.setIcon(R.drawable.mypage_work);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                }

                //tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
            }
            //선택되지 않은 탭일 때
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //아이콘 색상을 #0070C0 으로 설정
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.drawable.reservation);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.place);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ticket);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.notification);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                    case 4:
                        tab.setIcon(R.drawable.mypage);
                        tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                        break;
                }
                //tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}