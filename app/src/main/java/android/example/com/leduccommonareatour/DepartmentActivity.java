package android.example.com.leduccommonareatour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DepartmentFragment())
                .commit();
    }
}