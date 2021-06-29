package mdc.licensekeyupgrade;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

class AsyncTask extends android.os.AsyncTask<Object, Object, Object> {
    public static int THEME_DIALOG = 2;
    boolean bCancelBtn = false;
    boolean bClickBackToCancel = true;
    private boolean bIndeterminate;
    public boolean bRunImmediately = false;
    boolean bShowProcessDialog = false;
    public int command;
    Context context;
    public Activity controller;
    String msgProcessDialog = "Processing...";
    setOnCancelListener onCancel;
    setOnPreExecute onPreExcute;
    public setOnCompeteTask onUpdateInterface;
    ProgressDialog progressDialog = null;
    int styleProcessDialog = 0;
    ITask task;

    public interface ITask {
        Object executeTask(Object obj);
    }

    public interface setOnCancelListener {
        void onCancelListener(Object obj);
    }

    public interface setOnCompeteTask {
        void onComplete(int i, Activity activity, Object obj);
    }

    public interface setOnPreExecute {
        void onPreExucute(Object obj);
    }

    public interface setOnUpdateProcess {
        boolean onUpdateProcess(Object obj);
    }

    public AsyncTask(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public void dismissProgressDialog() {
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            try {
                this.progressDialog.dismiss();
            } catch (IllegalArgumentException unused) {
            }
            this.progressDialog = null;
        }
    }

    private void showProgressDialog() {
        if (this.bShowProcessDialog) {
            this.progressDialog = new ProgressDialog(this.context);
            this.progressDialog.setMessage(this.msgProcessDialog);
            this.progressDialog.setIndeterminate(this.bIndeterminate);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    Toast.makeText(AsyncTask.this.context, "Process canceled", 0).show();
                    AsyncTask.this.cancel(true);
                    if (AsyncTask.this.onCancel != null) {
                        AsyncTask.this.onCancel.onCancelListener((Object) null);
                    }
                }
            });
            if (this.bCancelBtn) {
                this.progressDialog.setCancelable(false);
                this.progressDialog.setButton(-3, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AsyncTask.this.dismissProgressDialog();
                        Toast.makeText(AsyncTask.this.context, "Process canceled", 0).show();
                        AsyncTask.this.cancel(true);
                    }
                });
            }
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(this.bClickBackToCancel);
            if (this.styleProcessDialog == 1 && !this.bIndeterminate) {
                this.progressDialog.setMax(100);
            }
            this.progressDialog.setProgressStyle(this.styleProcessDialog);
            this.progressDialog.show();
        }
    }

    public void configProcessDialog(int i, boolean z, boolean z2, boolean z3, String str) {
        this.bShowProcessDialog = true;
        this.bClickBackToCancel = z2;
        this.styleProcessDialog = i;
        this.bCancelBtn = z;
        this.bIndeterminate = z3;
        if (str != null) {
            this.msgProcessDialog = str;
        }
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... objArr) {
        Object obj = objArr[0];
        if (this.task != null) {
            return this.task.executeTask(obj);
        }
        return null;
    }

    public boolean isComplete() {
        return getStatus() == AsyncTask.Status.FINISHED;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object obj) {
        dismissProgressDialog();
        if (this.onUpdateInterface != null) {
            this.onUpdateInterface.onComplete(this.command, this.controller, obj);
        }
        super.onPostExecute(obj);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        if (this.onPreExcute != null) {
            this.onPreExcute.onPreExucute((Object) null);
        } else {
            showProgressDialog();
        }
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Object... objArr) {
        if (this.progressDialog != null) {
            this.progressDialog.setProgress(objArr[0].intValue());
        }
        super.onProgressUpdate(objArr);
    }

    public void setController(Activity activity) {
        this.controller = activity;
    }

    public void setOnCancelListener(setOnCancelListener setoncancellistener) {
        this.onCancel = setoncancellistener;
    }

    public void setOnCompleteTaskListener(setOnCompeteTask setoncompetetask) {
        this.onUpdateInterface = setoncompetetask;
    }

    public void setOnPreExcute(setOnPreExecute setonpreexecute) {
        this.onPreExcute = setonpreexecute;
    }

    public void setRunImmediately(boolean z) {
        this.bRunImmediately = z;
    }

    public void start(int i, Object obj) {
        this.command = i;
        Object[] objArr = {obj};
        if (!this.bRunImmediately || Build.VERSION.SDK_INT < 11) {
            execute(objArr);
        } else {
            executeOnExecutor(THREAD_POOL_EXECUTOR, objArr);
        }
    }

    public void start(Object obj, ITask iTask) {
        this.task = iTask;
        Object[] objArr = {obj};
        if (!this.bRunImmediately || Build.VERSION.SDK_INT < 11) {
            execute(objArr);
        } else {
            executeOnExecutor(THREAD_POOL_EXECUTOR, objArr);
        }
    }

    public void stop() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    public void updateProgress(int i) {
        publishProgress(new Object[]{Integer.valueOf(i)});
    }
}
