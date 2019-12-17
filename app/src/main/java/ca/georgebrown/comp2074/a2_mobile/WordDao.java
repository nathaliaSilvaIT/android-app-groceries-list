package ca.georgebrown.comp2074.a2_mobile;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    void Insert(Word word);

    @Delete
    void Delete(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAllWords();
}
