package android.example.com.leduccommonareatour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SpecialtyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SpecialtyFragment())
                .commit();
    }
}