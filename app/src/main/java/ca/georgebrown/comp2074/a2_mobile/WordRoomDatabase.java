package ca.georgebrown.comp2074.a2_mobile;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 2, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTANCE;

    private static Callback callback =
            new Callback(){
                    public void onOpen(@NonNull SupportSQLiteDatabase db){
                        super.onOpen(db);
                        new PopulateAsyncTask(INSTANCE.wordDao()).execute();
                    }
    };


    private static class PopulateAsyncTask extends AsyncTask<Void, Void, Void>{
        private WordDao dao;
        PopulateAsyncTask(WordDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) { return null; }

    }


    static WordRoomDatabase getDatabase( Context context){
        if(INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").
                            addCallback(callback).build();
                }
            }
        }
        return INSTANCE;
    }


}
