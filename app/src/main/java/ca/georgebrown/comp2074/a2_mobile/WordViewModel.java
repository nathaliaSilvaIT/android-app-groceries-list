package ca.georgebrown.comp2074.a2_mobile;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository myRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(Application application){
        super(application);
        myRepository = new WordRepository(application);
        allWords = myRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    void insert(Word word){
        myRepository.insert(word);
    }


    public void delete(Word word){
        myRepository.delete(word);
    }
}
