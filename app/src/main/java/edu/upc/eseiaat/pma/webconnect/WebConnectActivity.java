package edu.upc.eseiaat.pma.webconnect;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WebConnectActivity extends AppCompatActivity {

    private TextView content;
    private EditText edit_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_connect);

        content = (TextView) findViewById(R.id.content);
        edit_url = (EditText) findViewById(R.id.edit_url);
    }

    public void connect(View view) {
        String surl = edit_url.getText().toString();
        new WebFetchTask().execute(surl);
    }

    private class WebFetchTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... surls) {
            String cont = WebFetcher.getUrl(surls[0]);
            return cont;
        }

        @Override
        protected void onPostExecute(String cont) {
            content.setText(cont);
        }
    }

}
