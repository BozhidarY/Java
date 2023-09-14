package lab19.Songs;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class LoadSongs {
    Gson gson = new Gson();

    public void loadFromFile(String filePath){
        try(FileReader fileReader = new FileReader(filePath)){
            SongData songData = gson.fromJson(fileReader, SongData.class);
            System.out.println("Song List{ ");
            for(Songs songData1: songData.getSongsList()){
                System.out.println(songData1);
            }
            System.out.println("}");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
