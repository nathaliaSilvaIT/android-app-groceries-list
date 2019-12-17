package ca.georgebrown.comp2074.a2_mobile;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    public abstract WordDao wordDao();
    private static volatile WordDatabase myInstance;

    private static Callback callback =
            new Callback(){

        public void onOpen(@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new populateAsyncTask(myInstance.wordDao()).execute();
                }

    };

    private static class populateAsyncTask extends AsyncTask<Void, Void, Void>{
        private final WordDao dao;

        populateAsyncTask(WordDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }

    static WordDatabase getDatabase(final Context context){
            if(myInstance == null) {
                synchronized (WordDatabase.class) {
                    if (myInstance == null) {
                        myInstance = Room.databaseBuilder(context.getApplicationContext(),
                                WordDatabase.class, "word_database").addCallback(callback).build();

                    }
                }
            }
            return myInstance;
        }


}
