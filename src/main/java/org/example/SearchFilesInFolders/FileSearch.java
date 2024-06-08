package org.example.SearchFilesInFolders;

import java.io.File;
import java.util.List;

public class FileSearch {
        public static void searchFiles(File folder, List<File> fileList) {
        if (folder.isDirectory())
        {
            File[] directoryFiles = folder.listFiles();
            if (directoryFiles != null)
            {
                for (File file : directoryFiles)
                {
                    if (file.isDirectory())
                    {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".json") ||file.getName().toLowerCase().endsWith(".csv") ) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}




