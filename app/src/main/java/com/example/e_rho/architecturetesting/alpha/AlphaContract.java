package com.example.e_rho.architecturetesting.alpha;

import java.util.List;

/**
 * Created by e_rho on 10/11/2017.
 */

public interface AlphaContract {
    interface Presenter {
        void start();
    }
    interface View {
        void displayStrings(List<String> strings);
    }
}
