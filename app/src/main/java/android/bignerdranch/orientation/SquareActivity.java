package android.bignerdranch.orientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SquareActivity extends AppCompatActivity {

    ImageView mSquare;

    public static final String EXTRA_TAP_INSIDE_SQUARE = "com.android.bignerdranch.orientation.tap_inside_square";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        int squareSize = getIntent().getIntExtra(MainActivity.EXTRA_SQUARE_SIZE, 100);
        if (squareSize == 0) {
            squareSize = 1;
        }

        mSquare = findViewById(R.id.square_shape);

        ViewGroup.LayoutParams params = mSquare.getLayoutParams();
        params.height = squareSize*5;
        params.width = squareSize*5;

        mSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent carries data back to Activity that launches this one
                Intent returnIntent = new Intent();
                // Add the value true as an extra
                returnIntent.putExtra(EXTRA_TAP_INSIDE_SQUARE, true);
                // Everything went well
                setResult(RESULT_OK, returnIntent);
                // End this Activity. Android will remove it from the screen, then create and show
                // the previous Activity - MainActivity in this case
                finish();
            }
        });

        View mainView = findViewById(android.R.id.content);
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_TAP_INSIDE_SQUARE, false);
                setResult(RESULT_OK, returnIntent);
                finish();
        }
        });


    }
}
