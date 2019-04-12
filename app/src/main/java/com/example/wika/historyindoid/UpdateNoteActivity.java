package com.example.wika.historyindoid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wika.historyindoid.database.DBNote;

public class UpdateNoteActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBNote dbNote;
    Button ton1;
    EditText text1, text2, text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        dbNote = new DBNote(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);

        SQLiteDatabase db = dbNote.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM data WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);

        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbNote.getWritableDatabase();
                db.execSQL("update data set nama='"+
                        text2.getText().toString() +"', isi='" +
                        text3.getText().toString()+ "' where no='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                BerandaActivity.berandaActivity.RefreshList();
                finish();
            }
        });

    }
}
