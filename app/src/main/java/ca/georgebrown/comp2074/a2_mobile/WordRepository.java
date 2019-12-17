package ca.georgebrown.comp2074.a2_mobile;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    WordRepository(Application application) {
        WordDatabase db = WordDatabase.getDatabase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    void insert(Word word){
        new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao dao;

        insertAsyncTask(WordDao wdao){
            dao = wdao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            dao.Insert(words[0]);
            return null;
        }
    }

    public void delete(Word word){
        new deleteAsyncTask(wordDao).execute(word);
    }

    private static class deleteAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao dao;

        deleteAsyncTask(WordDao wdao){
            dao = wdao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            dao.Delete(words[0]);
            return null;
        }
    }

}
