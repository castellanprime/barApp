package com.spartahacks.app.bargamescores;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import static android.content.ContentValues.TAG;


/**
 * Created by rogal-dorn on 2/3/17.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "games.db";

    private final Context context;
    private static DBHelper instance;

    public synchronized static DBHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new DBHelper(ctx.getApplicationContext());
        }
        return instance;
    }
    /**
     * Creates a new instance of the simple open helper.
     *
     * @param context Context to read assets. This will be helped by the
     *
    instance.
     */
    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

        // This will happen in onConfigure for API >= 16
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            SQLiteDatabase db = getWritableDatabase();
            db.enableWriteAheadLogging();
            db.execSQL("PRAGMA foreign_keys = ON;");
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        applySqlScript(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GameItem.class.getSimpleName().toUpperCase());
        db.execSQL("DROP TABLE IF EXISTS " + GameItemDesc.class.getSimpleName().toUpperCase());
        applySqlScript(db);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        setWriteAheadLoggingEnabled(true);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void applySqlScript(SQLiteDatabase db){
        BufferedReader reader = null;
        try {
            final InputStream inputStream =
                    context.getAssets().open("games.sql");
            reader =
                    new BufferedReader(new InputStreamReader(inputStream));
            final StringBuilder statement = new StringBuilder();
            for (String line; (line = reader.readLine()) != null;) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "Reading line -> " + line);
                }
                // Ignore empty lines
                if (!TextUtils.isEmpty(line) && !line.startsWith("--")) {
                    statement.append(line.trim());
                }
                if (line.endsWith(";")) {
                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "Running statement " + statement);
                    }
                    db.execSQL(statement.toString());
                    statement.setLength(0);
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Could not apply SQL file", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.w(TAG, "Could not close reader", e);
                }
            }
        }
    }

}
