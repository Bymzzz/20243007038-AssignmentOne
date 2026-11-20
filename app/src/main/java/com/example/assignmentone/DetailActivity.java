package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Keep the content clear of system bars.
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

        // Get the selected topic: 0, 1, 2 or 3.
        int topicIndex = getIntent().getIntExtra("topic_index", 0);

        // Read the three arrays from array.xml.
        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images);

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles);

        String[] contents = getResources().getStringArray(
                R.array.string_array_content);

        // Short topic names used in the banner.
        String[] topicNames = {
                getString(R.string.topic_facilities),
                getString(R.string.topic_events),
                getString(R.string.topic_clubs),
                getString(R.string.topic_support)
        };

        // Find the views in activity_detail.xml.
        ImageView image = findViewById(R.id.detail_image);
        TextView topic = findViewById(R.id.detail_topic);
        TextView title = findViewById(R.id.detail_title);
        TextView content = findViewById(R.id.detail_content);

        // Find the image using its name from the array.
        int imageId = getResources().getIdentifier(
                imageNames[topicIndex].trim(),
                "drawable",
                getPackageName());

        // Update the screen with the selected topic's data.
        image.setImageResource(imageId);
        image.setContentDescription(topicNames[topicIndex]);

        topic.setText(topicNames[topicIndex]);
        title.setText(titles[topicIndex].trim());
        content.setText(contents[topicIndex].trim());
    }
}