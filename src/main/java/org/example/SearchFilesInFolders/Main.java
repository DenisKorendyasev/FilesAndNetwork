package org.example.SearchFilesInFolders;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String path = "FilesAndNetwork/src/main/folders/stations-data";
        ArrayList<File> fileList = new ArrayList<>();
        File file = new File(path);
        FileSearch.searchFiles(file, fileList);
        for (File f : fileList){
            System.out.println(f.getAbsolutePath());
        }

    }


}
