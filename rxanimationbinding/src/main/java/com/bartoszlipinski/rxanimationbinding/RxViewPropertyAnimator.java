/**
 * Copyright 2016 Bartosz Lipinski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bartoszlipinski.rxanimationbinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewPropertyAnimator;

import rx.Observable;

import static com.bartoszlipinski.rxanimationbinding.internal.Preconditions.checkNotNull;

public class RxViewPropertyAnimator {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static Observable<Void> starts(ViewPropertyAnimator animator) {
        checkNotNull(animator, "animator == null");
        return Observable.create(ViewPropertyAnimatorListenerOnSubscribe.forTypicalEvents(animator, AnimationEvent.START));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static Observable<Void> ends(ViewPropertyAnimator animator) {
        checkNotNull(animator, "animator == null");
        return Observable.create(ViewPropertyAnimatorListenerOnSubscribe.forTypicalEvents(animator, AnimationEvent.END));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static Observable<Void> cancels(ViewPropertyAnimator animator) {
        checkNotNull(animator, "animator == null");
        return Observable.create(ViewPropertyAnimatorListenerOnSubscribe.forTypicalEvents(animator, AnimationEvent.CANCEL));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static Observable<Void> repeats(ViewPropertyAnimator animator) {
        checkNotNull(animator, "animator == null");
        return Observable.create(ViewPropertyAnimatorListenerOnSubscribe.forTypicalEvents(animator, AnimationEvent.REPEAT));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static Observable<Void> updates(ViewPropertyAnimator animator) {
        checkNotNull(animator, "animator == null");
        return Observable.create(ViewPropertyAnimatorListenerOnSubscribe.forUpdates(animator));
    }

}