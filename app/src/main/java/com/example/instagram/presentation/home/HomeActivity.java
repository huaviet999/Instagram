package com.example.instagram.presentation.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseActivity;
import com.example.instagram.presentation.favorite.FavoriteFragment;
import com.example.instagram.presentation.home.fragment.HomeFragment;
import com.example.instagram.presentation.profile.ProfileFragment;
import com.example.instagram.presentation.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.core.content.ContextCompat;
import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created by Viet Hua on 2/14/2020
 */
public class HomeActivity extends BaseActivity implements HomeContract.View {
    private static final String TAG = HomeActivity.class.getSimpleName();
    @BindView(R.id.nav_home)
    BottomNavigationView navHome;
    @Inject
    HomeContract.Presenter presenter;

    public static void showHomeActivity(AppCompatActivity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setupHomeBottomNav();
//        setupToolbar();

        addFragment(HomeFragment.getInstance(), HomeFragment.TAG, R.id.frag_home_container);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_home;
    }

    private static final int TAG_HOME = 0;
    private static final int TAG_SEARCH = 1;
    private static final int TAG_ADD = 2;
    private static final int TAG_FAVORITE = 3;
    private static final int TAG_PERSON = 4;
    private static final int DELAY_TIME = 300; // MILLISECONDS

    public void setupHomeBottomNav() {
        navHome.setOnNavigationItemSelectedListener(listener);
    }
//
//    public void setupToolbar() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//    }

    BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.item_home:
                    openFragmentByTag(TAG_HOME);
                    break;
                case R.id.item_search:
                    openFragmentByTag(TAG_SEARCH);
                    break;
                case R.id.item_add:
                    openFragmentByTag(TAG_ADD);
                    break;
                case R.id.item_favorite:
                    openFragmentByTag(TAG_FAVORITE);
                    break;
                case R.id.item_person:
                    openFragmentByTag(TAG_PERSON);
                    break;
            }
            return true;
        }
    };

    public void openFragmentByTag(int tag) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (tag) {
                    case TAG_HOME:
                        replaceFragment(HomeFragment.getInstance(), HomeFragment.TAG, R.id.frag_home_container);
                        break;
                    case TAG_SEARCH:
                        replaceFragment(SearchFragment.getInstance(), SearchFragment.TAG, R.id.frag_home_container);
                        break;
                    case TAG_ADD:
                        showWarningMessage("DANG PHAT TRIEN");
                        break;
                    case TAG_FAVORITE:
                        replaceFragment(FavoriteFragment.getInstance(), FavoriteFragment.TAG, R.id.frag_home_container);
                        break;
                    case TAG_PERSON:
                        replaceFragment(ProfileFragment.getInstance(), ProfileFragment.TAG, R.id.frag_home_container);
                        break;
                }
            }
        }, DELAY_TIME);
    }

}
