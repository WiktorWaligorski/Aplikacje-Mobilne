package edu.zsk.zadanie;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "most_important";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupInsets();
        createNotificationChannel();
        setupButtons();
    }

    private void setupInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
    }

    private void setupButtons() {
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(v -> sendNotification(
                activity_two.class,
                "Najważniejsze powiadomienie!!!",
                "Treść najważniejszej wiadomości",
                NotificationCompat.PRIORITY_MAX
        ));

        btn2.setOnClickListener(v -> sendNotification(
                activity_three.class,
                "Najmniej ważne pow",
                "Mało ważne info",
                NotificationCompat.PRIORITY_MIN
        ));
    }

    private void sendNotification(Class<?> targetActivity, String title, String text, int priority) {
        Intent intent = new Intent(this, targetActivity);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.clker_free_vector_images_banana_310449_1280)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(priority)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify((int) System.currentTimeMillis(), builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "najważniejsze",
                    NotificationManager.IMPORTANCE_HIGH
            );

            channel.enableLights(true);
            channel.setLightColor(Color.GREEN);
            channel.enableVibration(true);

            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }
}