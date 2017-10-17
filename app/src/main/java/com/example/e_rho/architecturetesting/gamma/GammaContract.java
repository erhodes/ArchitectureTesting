package com.example.e_rho.architecturetesting.gamma;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */

public interface GammaContract {
    interface Presenter {
        void start();
        void stop();
        void onAddString();
    }
    interface View {
        void displayStrings(List<String> strings);
    }
}
