package si.uni_lj.fe.lablog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hide the back button in MainActivity
        View backButton = findViewById(R.id.backButton);
        backButton.setVisibility(View.GONE);

        // Find the CardView by its ID
        View latestEntriesCard = findViewById(R.id.latestEntriesCard);

        // Set an OnClickListener to the CardView
        latestEntriesCard.setOnClickListener(v -> {
            // Create an Intent to navigate to LatestEntryActivity
            Intent intent = new Intent(MainActivity.this, LatestEntryActivity.class);
            // Start the activity
            startActivity(intent);
        });


        // Find the addButton by its ID
        View addButton = findViewById(R.id.addButton);

        // Set an OnClickListener to the addButton
        addButton.setOnClickListener(v -> {
            // Create an Intent to navigate to NewEntryActivity
            Intent intent = new Intent(MainActivity.this, NewEntryActivity.class);
            // Start the activity
            startActivity(intent);
        });
    }
}
