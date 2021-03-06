package com.shiyan.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle3.components.RxActivity;
import com.trello.rxlifecycle3.components.support.RxFragmentActivity;

public abstract class MVPFragmentActivity<P extends MvpPresenter> extends RxFragmentActivity implements MvpView {

    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            if(p == null) {

                p = bindPresenter();

                if(p != null){

                    p.attachView(this);

                }
            }

    }

    /**
     * 创建Presenter
     * @return
     */
    public abstract P bindPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(p != null) {

            p.detachView();

        }
    }
}
