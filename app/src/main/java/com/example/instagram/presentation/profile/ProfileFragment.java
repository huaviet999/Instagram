package com.example.instagram.presentation.profile;

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
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import dagger.android.support.AndroidSupportInjection;

/**
 * Create by Viet Hua on 2/14/2020
 */
public class ProfileFragment extends BaseFragment implements ProfileContract.View {

    public static final String TAG = ProfileFragment.class.getSimpleName();

    public static ProfileFragment getInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle data = new Bundle();
        fragment.setArguments(data);
        return fragment;
    }

    @Inject
    ProfileContract.Presenter presenter;
    Context mContext;

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_profile;
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
    }

    private ProfileAdapter profileAdapter;

    public void preparePostRV(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_pic);
        profileAdapter = new ProfileAdapter(getContext(), listener);
        profileAdapter.setData(testData());
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3,1);
        lm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(profileAdapter);
    }

    private ItemClickListener<String> listener = new ItemClickListener<String>() {
        @Override
        public void onClickListener(int position, String user) {

        }

        @Override
        public void onLongClickListener(int position, String user) {

        }
    };

    public List<String> testData() {
        List<String> data = new ArrayList<>();
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/09/29/09/12/laugh-2798443_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/02/08/14/36/winter-4830285__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1500258593672-b080c40f4b02?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        data.add("https://images.unsplash.com/photo-1542044896530-05d85be9b11a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1225&q=80");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1500258593672-b080c40f4b02?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        data.add("https://images.unsplash.com/photo-1542044896530-05d85be9b11a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1225&q=80");
        data.add("https://cdn.pixabay.com/photo/2019/09/10/07/06/beauty-4465397__340.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1543248939-ff40856f65d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=633&q=80");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2020/01/17/16/42/food-4773380_960_720.jpg");
        data.add("https://images.unsplash.com/photo-1500258593672-b080c40f4b02?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        data.add("https://images.unsplash.com/photo-1542044896530-05d85be9b11a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1225&q=80");
        return data;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
