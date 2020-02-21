package com.instagram.domain;

import com.instagram.domain.executor.ExecutionThread;

import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;


public abstract class MaybeUseCase<P> {
    private ExecutionThread executionThread;
    private CompositeDisposable compositeDisposable;

    public MaybeUseCase(ExecutionThread executionThread) {
        this.executionThread = executionThread;
        this.compositeDisposable = new CompositeDisposable();
    }

    protected abstract Maybe buildUseCase(P param);

    public void execute(DisposableMaybeObserver observer, P param) {
        Maybe maybe = buildUseCase(param).subscribeOn(executionThread.io())
                .observeOn(executionThread.main());
        addDisposable((Disposable) maybe.subscribeWith(observer));
    }

    public void addDisposable(Disposable d) {
        this.compositeDisposable.add(d);
    }
}
