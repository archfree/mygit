/**
 * Copyright 2009 Joe LaPenna
 */
/**
 * Copyright (C) 2010 XiaMen Stelcom Information & Technology Co., Ltd.
 */

package com.stelcom.tcpos.app;

import com.stelcom.tcpos.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Porting code from foursquared.
 * @date December 30, 2010
 * @author zhangtc (zhangtc@stelcom.com.cn)
 */
public class LoadableListActivity extends ListActivity {

    private int mNoSearchResultsString = getNoSearchResultsStringId();

    private ProgressBar mEmptyProgress;
    private TextView mEmptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.loadable_list_activity);
        mEmptyProgress = (ProgressBar)findViewById(R.id.emptyProgress);
        mEmptyText = (TextView)findViewById(R.id.emptyText);
        setLoadingView();
        
        getListView().setDividerHeight(0);
    }

    public void setEmptyView() {
        mEmptyProgress.setVisibility(ViewGroup.GONE);
        mEmptyText.setText(mNoSearchResultsString);
    }

    public void setLoadingView() {
        mEmptyProgress.setVisibility(ViewGroup.VISIBLE);
        mEmptyText.setText("");//R.string.loading);
    }
    
    public void setLoadingView(String loadingText) {
    	setLoadingView();
        mEmptyText.setText(loadingText);
    }

    public int getNoSearchResultsStringId() {
        return R.string.no_search_results;
    }
}
