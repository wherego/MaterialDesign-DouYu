package com.jiezzzo.douyu.common.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by oaier on 2017/3/28.
 */

public final class ActivityUtils {

    private ActivityUtils() {
    }

    public static void addFragment (@NonNull final FragmentManager fragmentManager,
                                              @NonNull final Fragment fragment, final int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

}
