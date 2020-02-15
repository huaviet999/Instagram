package com.example.instagram.presentation.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseFragment;
import com.example.instagram.presentation.base.ItemClickListener;
import com.instagram.domain.Model.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {
    public static final String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle data = new Bundle();
        fragment.setArguments(data);
        return fragment;
    }

    @Inject
    HomeFragmentContract.Presenter presenter;
    Context mContext;

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void onMyCreateView(View view) {
        presenter.takeView(this);
        preparePostRV(view);
       prepareToolbar(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);

        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    private HomePostAdapter homePostAdapter;


    public void preparePostRV(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_post);
        homePostAdapter = new HomePostAdapter(getContext(), listener);
        homePostAdapter.setData(testData());
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(homePostAdapter);
    }
    public void prepareToolbar(View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_home);
    }


    private ItemClickListener<Post> listener = new ItemClickListener<Post>() {
        @Override
        public void onClickListener(int position, Post post) {
            Log.d(TAG, "ONCLICK TEST" + position);
        }

        @Override
        public void onLongClickListener(int position, Post post) {

        }
    };

    public List<Post> testData() {
        List<Post> data = new ArrayList<>();
        data.add(new Post("1", "https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg", "MAN WITH A BIKE", "HUA VIET"));
        data.add(new Post("2", "https://images.unsplash.com/photo-1573049784267-7275a3ba597e?ixlib=rb-1.2.1&auto=format&fit=crop&w=633&q=80", "China Town", "NGUYEN TU"));
        data.add(new Post("3", "https://images.unsplash.com/photo-1560214640-9a9455c94590?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80", "PICNIC TIME", "JOHN"));
        data.add(new Post("4", "https://images.unsplash.com/photo-1570176776375-c56777d1ba2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80", "Nice weather", "KEVIN"));
        return data;
    }
}
