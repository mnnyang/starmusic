package com.mnnyang.starmusic.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mnnyang.starmusic.R;
import com.mnnyang.starmusic.adapter.ArtistAdapter;
import com.mnnyang.starmusic.adapter.RecyclerBaseAdapter;
import com.mnnyang.starmusic.app.Cache;
import com.mnnyang.starmusic.util.binding.BindView;
import com.mnnyang.starmusic.util.helper.StatusHelper;

/**
 * Created by mnnyang on 17-4-12.
 */

public class ArtistFragment extends PagerFragment
        implements RecyclerBaseAdapter.ItemClickListener, ArtistAdapter.ItemMoreClickListener {

    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.ll_load_fail)
    LinearLayout llLoadFail;
    private ArtistAdapter artistAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_recycler_view;
    }

    @Override
    public void initData() {
        super.initData();
        initRecyclerView();
        initStatus();
    }

    @Override
    public void initListener() {
        super.initListener();
        artistAdapter.setItemClickListener(this);
        artistAdapter.setMoreClickListener(this);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        artistAdapter = new ArtistAdapter(R.layout.adapter_default_title_second_title, Cache.getArtists());
        recyclerView.setAdapter(artistAdapter);
    }

    private void initStatus() {
        if (Cache.getMusicList().isEmpty()) {
            StatusHelper.status(recyclerView, llLoading, llLoadFail, StatusHelper.Status.FAIL);
            TextView tvFailInfo = (TextView) llLoadFail.findViewById(R.id.tv_load_fail_info);
            tvFailInfo.setText("未找到任何艺术家");
        }
    }

    @Override
    public void onItemClick(View view, RecyclerBaseAdapter.ViewHolder holder) {

    }

    @Override
    public void onItemLongClick(View view, RecyclerBaseAdapter.ViewHolder holder) {

    }

    @Override
    public void onMoreClick(View view, int position) {

    }
}
