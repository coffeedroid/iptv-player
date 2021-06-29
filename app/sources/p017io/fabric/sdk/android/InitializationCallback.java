package p017io.fabric.sdk.android;

/* renamed from: io.fabric.sdk.android.InitializationCallback */
public interface InitializationCallback<T> {
    public static final InitializationCallback EMPTY = new Empty();

    /* renamed from: io.fabric.sdk.android.InitializationCallback$Empty */
    public static class Empty implements InitializationCallback<Object> {
        private Empty() {
        }

        public void failure(Exception exc) {
        }

        public void success(Object obj) {
        }
    }

    void failure(Exception exc);

    void success(T t);
}
