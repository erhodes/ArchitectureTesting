package com.example.e_rho.architecturetesting.alpha;

import com.example.e_rho.architecturetesting.model.DataModel;

/**
 * Created by e_rho on 10/11/2017.
 */

public class AlphaPresenter implements
        AlphaContract.Presenter,
        DataModel.CallbackListener {
    private AlphaContract.View mView;
    private DataModel mDataModel;

    public AlphaPresenter(AlphaContract.View view, DataModel dataModel) {
        mView = view;
        mDataModel = dataModel;
        mDataModel.addCallbackListener(this);
    }

    public void start() {
        mView.displayStrings(mDataModel.getStrings());
    }

    @Override
    public void onStringsUpdated() {
        mView.displayStrings(mDataModel.getStrings());
    }
}
