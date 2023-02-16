package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdaptor;
    private ListView listView;
    private Button button;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(view);
            }
        });
        items = new ArrayList<>();
        itemsAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdaptor);
        setUplistViewListener();
    }

    private void setUplistViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "items removed", Toast.LENGTH_LONG).show();
                items.remove(i);
                itemsAdaptor.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem (View view){
        EditText input = findViewById(R.id.editTextTextPersonName);
        String itemText = input.getText().toString();

        if(!(itemText.equals(" "))){
            itemsAdaptor.add(itemText);
            input.setText("");
        }else
        {
            Toast.makeText(getApplicationContext(), "please enter text...", Toast.LENGTH_SHORT).show();
        }
    }
}




