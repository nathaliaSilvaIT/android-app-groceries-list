package ca.georgebrown.comp2074.a2_mobile;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "word_table")
public class Word implements Serializable{


    @PrimaryKey
    @NonNull
    @ColumnInfo(name="word")
    private String word;


    public Word(@NotNull String word) {
        this.word = word;
    }

    @NotNull
    public String getWord() {
        return word;
    }

    public void setWord(@NotNull String word) {
        this.word = word;
    }


}
