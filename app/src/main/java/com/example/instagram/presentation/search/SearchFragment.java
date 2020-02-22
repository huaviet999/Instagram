package com.example.instagram.presentation.search;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseFragment;
import com.example.instagram.presentation.base.ItemClickListener;
import com.example.instagram.presentation.favorite.FavoriteAdapter;
import com.instagram.domain.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Viet Hua on 2/14/2020
 */
public class SearchFragment extends BaseFragment implements SearchContract.View {
    public static final String TAG = SearchFragment.class.getSimpleName();
    @Inject
    SearchContract.Presenter presenter;
    Context mContext;

    public static SearchFragment getInstance() {
        SearchFragment searchFragment = new SearchFragment();
        Bundle data = new Bundle();
        searchFragment.setArguments(data);
        return searchFragment;
    }

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_search;
    }


    @Override
    protected void onMyCreateView(View view) {
        presenter.takeView(this);
        preparePostRV(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private SearchAdapter searchAdapter;
    public void preparePostRV(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_search);
        searchAdapter = new SearchAdapter(getContext(), listener);
        searchAdapter.setData(testData());
        searchAdapter.setOnFollowButtonClickListener(followButtonClickListener);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(searchAdapter);
    }
    private SearchAdapter.FollowButtonClickListener followButtonClickListener = new SearchAdapter.FollowButtonClickListener() {
        @Override
        public void onClickListener() {
            showMessage("Nhấn theo dõi thành công");
        }

        @Override
        public void onLongClickListener() {

        }
    };
    private ItemClickListener<User> listener = new ItemClickListener<User>() {
        @Override
        public void onClickListener(int position, User user) {

        }

        @Override
        public void onLongClickListener(int position, User user) {

        }
    };

    public List<User> testData() {
        List<User> data = new ArrayList<>();
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        data.add(new User("1", "huaviet999", "viet","Viet Hua","https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg","ABCED"));
        return data;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
