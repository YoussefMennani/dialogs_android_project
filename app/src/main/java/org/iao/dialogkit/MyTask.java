package org.iao.dialogkit;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class MyTask extends AsyncTask<Void, Integer, String> {

    private Context context;
    private ProgressDialog progressDialog;

    public MyTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Create and show the ProgressDialog
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        // Simulate a time-consuming task
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(500); // Simulate work being done
                publishProgress(i); // Update progress
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Task completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        // Update the progress value in the ProgressDialog
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        // Dismiss the ProgressDialog when the task is completed
        progressDialog.dismiss();
    }
}
