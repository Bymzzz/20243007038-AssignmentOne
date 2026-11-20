package com.example.assignmentone;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        // Keep content clear of system bars.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom);

                    return insets;
                });
    }


    public void onFacilitiesClick(View view) {
        openDetail(0);
    }

    public void onEventsClick(View view) {
        openDetail(1);
    }

    public void onClubsClick(View view) {
        openDetail(2);
    }

    public void onSupportClick(View view) {
        openDetail(3);
    }

    // Open the detail screen with the selected topic index.
    private void openDetail(int topicIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("topic_index", topicIndex);
        startActivity(intent);
    }
}