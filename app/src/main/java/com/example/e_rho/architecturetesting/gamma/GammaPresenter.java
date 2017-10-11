package com.example.e_rho.architecturetesting.gamma;

import com.example.e_rho.architecturetesting.model.DataModel;

/**
 * Created by e_rho on 10/11/2017.
 */

public class GammaPresenter implements GammaContract.Presenter, DataModel.CallbackListener {
    private GammaContract.View mView;
    private DataModel mDataModel;

    public GammaPresenter(GammaContract.View view, DataModel dataModel) {
        mView = view;
        mDataModel = dataModel;
        mDataModel.addCallbackListener(this);
    }

    @Override
    public void start() {
        mView.displayStrings(mDataModel.getStrings());
    }

    @Override
    public void onAddString() {
        mDataModel.addString("worchesterize");
    }

    @Override
    public void onStringsUpdated() {
        mView.displayStrings(mDataModel.getStrings());
    }
}
