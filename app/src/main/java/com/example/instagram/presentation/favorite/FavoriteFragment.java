package com.example.instagram.presentation.favorite;

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
import com.instagram.domain.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Viet Hua on 2/14/2020
 */
public class FavoriteFragment extends BaseFragment implements FavoriteContract.View {
    public static final String TAG = FavoriteFragment.class.getSimpleName();

    public static FavoriteFragment getInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle data = new Bundle();
        fragment.setArguments(data);
        return fragment;
    }

    @Inject
    FavoriteContract.Presenter presenter;
    Context mContext;

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_favorite;
    }


    @Override
    protected void onMyCreateView(View view) {
        presenter.takeView(this);
        prepareToolbar(view);
        preparePostRV(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_bottom_navigation, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    public void prepareToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.favorite_toolbar);
        toolbar.setTitle("Hoạt động");
    }

    private FavoriteAdapter favoriteAdapter;

    public void preparePostRV(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_favorite);
        favoriteAdapter = new FavoriteAdapter(getContext(), listener);
        favoriteAdapter.setData(testData());
        favoriteAdapter.setOnFollowButtonClickListener(followButtonClickListener);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(favoriteAdapter);
    }

    private FavoriteAdapter.FollowButtonClickListener followButtonClickListener = new FavoriteAdapter.FollowButtonClickListener() {
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
    @OnClick(R.id.txt_recommend)
    public void onRecommendTextClick(){
      showFWarningDialog("ĐANG PHÁT TRIỂN");
    }
}
