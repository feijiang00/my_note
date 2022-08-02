package test;

import java.io.File;

/**
 * @date 2022/3/2 17:10
 */
public class a {

    public static void main(String[] args) {

        File file = new File("C:\\a");
        getFileAndDirectory(file);
    }

    /**
     * 统计该文件夹下的文件和文件夹数量
     * @param file
     */
    public  static void getFileAndDirectory(File file){
        int countFile = 0;
        int countDirectory = 0;
        if(file.isDirectory()){
            File []files = file.listFiles();
            for(File fileIndex:files){
                if(fileIndex.isDirectory()){
                    countDirectory++;
                    getFileAndDirectory(fileIndex);
                }else {
                    countFile++;
                }
            }
        }
        System.out.println("文件夹总数为："+countDirectory);
        System.out.println("文件总数为："+countFile);
    }
}
