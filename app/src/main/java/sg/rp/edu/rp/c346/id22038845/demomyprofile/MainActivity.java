package sg.rp.edu.rp.c346.id22038845.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName,etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etTxtName);
        etGPA = findViewById(R.id.etTxtGPA);


    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step1a: get the user input from the edit txt and store it in a variable
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString(); //float floatgpa = Float.parseFloat(etGPA.getText().toString());


        //Step1b: obtain an instance of the sharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //for singlular activity use, for multiple, you should use getSharedPreferences

        //step1c: obtain an instance of the sharedPreferences editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //step1d: add the key-value pair
        prefEdit.putString("name",strName); //is also use for updating, with commit statement, if removing = prefEdit.remove("key");
        prefEdit.putFloat("gpa", Float.parseFloat(strGPA));


        //step1e: call commit() to save the changes into sharedPreferences
        prefEdit.commit(); //commit(); writes the changes in both the in-memory(RAM) sharedPreferences,gives immediate visible results, prevents calling until operation completed while apply does not // apply(); writes the changes only to the in-memory sharedPreferences but schedules the write to the disk in the background,doesnt give immediate result

    }

    @Override
    protected void onResume() {
        super.onResume();

        //step2a: obtain an instance of the shared preferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //for singlular activity use, for multiple, you should use getSharedPreferences

        //step2b: retrieve the saved data from the sharedPreferences object
        String name = prefs.getString("name", "John");
        String gpa = String.valueOf(prefs.getFloat("gpa", 0));

        //step2c: update the Ui element with the value
        etName.setText(name);
        etGPA.setText(gpa);

    }
}