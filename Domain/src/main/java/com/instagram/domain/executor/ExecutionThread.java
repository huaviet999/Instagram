package com.instagram.domain.executor;


import io.reactivex.Scheduler;

/**
 * Created by Viet Hua on 2/21/2020
 */
public interface ExecutionThread {
    Scheduler io();

    Scheduler main();
}
