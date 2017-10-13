package com.example.e_rho.architecturetesting;

/**
 * Created by e_rho on 10/12/2017.
 */

public interface CentralNavigator {
    int FRAGMENT_ALPHA = 0;
    int FRAGMENT_BETA = 1;
    int FRAGMENT_GAMMA = 2;

    void switchToView(int viewPosition);
}
