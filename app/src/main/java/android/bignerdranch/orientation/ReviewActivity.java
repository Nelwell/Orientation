package android.bignerdranch.orientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewActivity extends AppCompatActivity {

    Button mYesButton;
    Button mNoButton;

    public static final String EXTRA_TAPPED_BUTTON = "com.android.bignerdranch.orientation.tap_yes_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        mYesButton = findViewById(R.id.yes_button);
        mNoButton = findViewById(R.id.no_button);

        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_TAPPED_BUTTON, true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_TAPPED_BUTTON, false);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
