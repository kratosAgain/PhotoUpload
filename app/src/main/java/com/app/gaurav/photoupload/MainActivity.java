package com.app.gaurav.photoupload;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    private Button addGroup;
    private EditText nameOfGroup;
    private TextView welcome;
    private Button addAndMoveToNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addGroup = (Button) findViewById(R.id.makeGroupButton);
        nameOfGroup = (EditText) findViewById(R.id.groupName);
        welcome = (TextView) findViewById(R.id.textView);
        addAndMoveToNextPage = (Button)findViewById(R.id.add);

        welcome.setText("Welcome " + this.getIntent().getExtras().getString("userName"));
        addGroup();


    }
    public void addGroup(){
        addGroup.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                welcome.setVisibility(View.INVISIBLE);
                addGroup.setVisibility(View.INVISIBLE);
                nameOfGroup.setVisibility(View.VISIBLE);
                addAndMoveToNextPage.setVisibility(View.VISIBLE);

                addAndMoveToNextPage.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v){
                        onAddBtnClick();
                    }
                });

            }
        });
    }
    public void onAddBtnClick(){
        Intent intent = new Intent(getApplicationContext(), AddImage.class);
        intent.putExtra("groupName",nameOfGroup.getText());
        startActivity(intent);

    }

}
