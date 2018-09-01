import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import com.example.puvvadaprasannasai.devathon18.R;

public class Database extends SQLiteOpenHelper{


    public Database(Context context) {
        super(context, "Case.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table case_details(cc_no text, section text, court text, date_filing text, name text, address text, mob_no text)");
        db.execSQL("Create table witness_details(cc_no text, w_no text, w_mob text, w_name text, w_address text)");
        db.execSQL("Create table hearing(cc_no text, hearing_date text)");
        db.execSQL("Create table proceedings(case_proceeding text, next_hearing text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
    }

    public void insert_case(SQLiteDatabase db){

        EditText cc_no=(EditText) findViewById(R.id.cc_no);
        EditText section=(EditText) findViewById(R.id.section);
        EditText court=(EditText) findViewById(R.id.court);
        EditText date_filing=(EditText) findViewById(R.id.date_filing);
        EditText name=(EditText) findViewById(R.id.name);
        EditText address=(EditText) findViewById(R.id.address);
        EditText mob_no=(EditText) findViewById(R.id.mob_no);

        db.insert()

    }
}
