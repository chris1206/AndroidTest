package com.chris.mytest.rxjava1;

/**
 * Created by Chris on 2018/5/28.
 */

public interface Disposable {
    /**
     * Dispose the resource, the operation should be idempotent.
     */
    void dispose();

    /**
     * Returns true if this resource has been disposed.
     * @return true if this resource has been disposed
     */
    boolean isDisposed();
}
