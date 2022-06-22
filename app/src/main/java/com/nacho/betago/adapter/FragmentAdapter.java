package com.nacho.betago.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nacho.betago.Fragment.BookFragment;
import com.nacho.betago.Fragment.HistoryFragment;
import com.nacho.betago.Fragment.NoticeFragment;
import com.nacho.betago.Fragment.SearchFragment;
import com.nacho.betago.Fragment.SettingFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public static int PAGE_POSITION = 4;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return BookFragment.newInstance();
            case 1:
                return SearchFragment.newInstance();
            case 2:
                return HistoryFragment.newInstance();
            case 3:
                return NoticeFragment.newInstance();
            case 4:
                return SettingFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
