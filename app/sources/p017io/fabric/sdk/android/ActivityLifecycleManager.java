package p017io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: io.fabric.sdk.android.ActivityLifecycleManager */
public class ActivityLifecycleManager {
    private final Application application;
    private ActivityLifecycleCallbacksWrapper callbacksWrapper;

    /* renamed from: io.fabric.sdk.android.ActivityLifecycleManager$ActivityLifecycleCallbacksWrapper */
    private static class ActivityLifecycleCallbacksWrapper {
        private final Application application;
        private final Set<Application.ActivityLifecycleCallbacks> registeredCallbacks = new HashSet();

        ActivityLifecycleCallbacksWrapper(Application application2) {
            this.application = application2;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public void clearCallbacks() {
            for (Application.ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.registeredCallbacks) {
                this.application.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public boolean registerLifecycleCallbacks(final Callbacks callbacks) {
            if (this.application == null) {
                return false;
            }
            C16361 r0 = new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    callbacks.onActivityCreated(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    callbacks.onActivityDestroyed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    callbacks.onActivityPaused(activity);
                }

                public void onActivityResumed(Activity activity) {
                    callbacks.onActivityResumed(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    callbacks.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    callbacks.onActivityStarted(activity);
                }

                public void onActivityStopped(Activity activity) {
                    callbacks.onActivityStopped(activity);
                }
            };
            this.application.registerActivityLifecycleCallbacks(r0);
            this.registeredCallbacks.add(r0);
            return true;
        }
    }

    /* renamed from: io.fabric.sdk.android.ActivityLifecycleManager$Callbacks */
    public static abstract class Callbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.application = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.callbacksWrapper = new ActivityLifecycleCallbacksWrapper(this.application);
        }
    }

    public boolean registerCallbacks(Callbacks callbacks) {
        return this.callbacksWrapper != null && this.callbacksWrapper.registerLifecycleCallbacks(callbacks);
    }

    public void resetCallbacks() {
        if (this.callbacksWrapper != null) {
            this.callbacksWrapper.clearCallbacks();
        }
    }
}
