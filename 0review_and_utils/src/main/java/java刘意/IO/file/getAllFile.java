package java刘意.IO.file;

import java.io.File;

/**
 * @date 2021/12/3 9:40
 */
public class getAllFile {
    public static void main(String[] args) {

        File files = new File("D:\\00NoteBook");
        getAllFilePath(files);

    }

    //获取某个文件夹下的所有文件夹目录
    public static void getAllFilePath(File files){
        File f[] = files.listFiles();
        if(f != null){
            for (File file : f) {
                if(file.isDirectory()){
                    System.out.println(file.getAbsolutePath());
                    getAllFilePath(file);
                }
            }
        }


    }
}
