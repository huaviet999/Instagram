package com.example.instagram.di;



import com.instagram.domain.executor.ExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Viet Hua on 2/21/2020
 */
public class ExecutionThreadImpl implements ExecutionThread {
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler main() {
        return AndroidSchedulers.mainThread();
    }
}
