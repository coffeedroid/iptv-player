package p017io.fabric.sdk.android;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p017io.fabric.sdk.android.services.common.IdManager;
import p017io.fabric.sdk.android.services.concurrency.DependsOn;
import p017io.fabric.sdk.android.services.concurrency.Task;

/* renamed from: io.fabric.sdk.android.Kit */
public abstract class Kit<Result> implements Comparable<Kit> {
    Context context;
    final DependsOn dependsOnAnnotation = ((DependsOn) getClass().getAnnotation(DependsOn.class));
    Fabric fabric;
    IdManager idManager;
    InitializationCallback<Result> initializationCallback;
    InitializationTask<Result> initializationTask = new InitializationTask<>(this);

    public int compareTo(Kit kit) {
        if (containsAnnotatedDependency(kit)) {
            return 1;
        }
        if (kit.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (!hasAnnotatedDependency() || kit.hasAnnotatedDependency()) {
            return (hasAnnotatedDependency() || !kit.hasAnnotatedDependency()) ? 0 : -1;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public boolean containsAnnotatedDependency(Kit kit) {
        if (hasAnnotatedDependency()) {
            for (Class isAssignableFrom : this.dependsOnAnnotation.value()) {
                if (isAssignableFrom.isAssignableFrom(kit.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground();

    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public Collection<Task> getDependencies() {
        return this.initializationTask.getDependencies();
    }

    public Fabric getFabric() {
        return this.fabric;
    }

    /* access modifiers changed from: protected */
    public IdManager getIdManager() {
        return this.idManager;
    }

    public abstract String getIdentifier();

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public abstract String getVersion();

    /* access modifiers changed from: package-private */
    public boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    /* access modifiers changed from: package-private */
    public final void initialize() {
        this.initializationTask.executeOnExecutor(this.fabric.getExecutorService(), null);
    }

    /* access modifiers changed from: package-private */
    public void injectParameters(Context context2, Fabric fabric2, InitializationCallback<Result> initializationCallback2, IdManager idManager2) {
        this.fabric = fabric2;
        this.context = new FabricContext(context2, getIdentifier(), getPath());
        this.initializationCallback = initializationCallback2;
        this.idManager = idManager2;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return true;
    }
}
