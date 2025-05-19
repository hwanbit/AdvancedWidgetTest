package kr.ac.kopo.advancedwidgettest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] items = {"AI SOFTWARE", "AISW of KOPO", "AI COMPUTER", "AI DATA", "AI MODEL"};

        AutoCompleteTextView auto = findViewById(R.id.auto);
        // 여러 개의 자동 완성 기능 사용 (컴마(,) 기준)
        MultiAutoCompleteTextView multi = findViewById(R.id.multi);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);


        MultiAutoCompleteTextView.CommaTokenizer commaToken = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(commaToken);
        multi.setAdapter(adapter);
    }
}