package com.yohan.healthycheck.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.data.APIController;

public class MainActivity extends AppCompatActivity {

    private static TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.test);
        test.setText("Vous n'avez rien scanné");

        APIController apiController = new APIController();
        apiController.start("3029330003533");
    }

    public static void updateUi(String text) {
        test.setText(text);
    }
}
