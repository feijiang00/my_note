package java刘意.IO;

import java.io.*;
//为了提高字符流读写的效率，引入了缓冲机制，进行字符批量的读写，提高了单个字符读写的效率。BufferedReader用于加快读取字符的速度，BufferedWriter用于加快写入的速度
//下面两个类都是可以用来读取文件的


public class demo1 {

    //读入文件（一行一行读取）
    public static String GetContent(File file){
        String content = "";
        if(file.exists()){
            try {
                //继承自字节读入流的字符读取流
                FileReader fr = new FileReader(file);
                //字符缓冲读取流：将文本写入字符输出流，缓冲字符，以提供给单个字符，数组，字符串的高校写入
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null){  //按行读取文件流的内容
                    content = content + line ;
                }
                fr.close();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件不存在");
        }
        return content;
    }


    //写入文件
    public static void InputContent(String[] ids, File file){
        if(file.exists()){
            try{
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (String tmp:ids
                     ) {
                    bw.write(tmp);
                    bw.newLine();
                }
                bw.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("文件不存在");
        }
    }

//    public void WriteNewLog(JSONArray jsonlog, String logpath){
//        System.out.println("----------------开始写新日志----------------");
//        try {
//            File newlog = new File(logpath + "\\log.txt");
//            if(!newlog.isFile()){
//                newlog.createNewFile();
//            }
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newlog),"utf-8"));
//            for(int i=0; i<jsonlog.length(); i++){
//                JSONObject logline = jsonlog.getJSONObject(i);
//                String loglinestr = logline.toString();
//                bw.write(loglinestr+"\r\n");
//            }
//            bw.close();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //实现单词的字典序排序，利用冒泡排序

    //比较两个单词的字典序大小
    public static boolean compareString(String param1, String param2) {
        char[] paramC1 = param1.toCharArray(); //String类 toCharArray() 方法将字符串转换为字符数组
        char[] paramC2 = param2.toCharArray();
        // 获取最短字符串长度
        int minLength = paramC1.length < paramC2.length ? paramC1.length
                : paramC2.length;
        for (int i = 0; i < minLength; i++) {
            if (paramC1[i] == paramC2[i]) {

            } else if (paramC1[i] > paramC2[i]) {
                return true;
            } else {
                return false;
            }
        }
        return paramC1.length > paramC2.length;
    }

    //冒泡排序
    public static void bubbleSort(String[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            // 循环之后下标i处为数组中最小的元素
            for (int j = arr.length - 1; j > i; j--) {
                if (!compareString(arr[j], arr[j - 1])) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    //交换两个元素，java中没有swap
    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        String dirname = "D:\\00NoteBook\\java\\一次java培训的纪实\\代码笔记\\输入输出流\\src\\top\\jiangkk\\文件管理\\test.txt"; //使用相对路径获取文件名
//        String dirname = "\\";
        File f = new File(dirname);
//        System.out.println(f.getAbsolutePath());      得到文件的绝对路径
//        System.out.println(f.length());       输出文件的长度
//        System.out.println(f.getName());      输出文件的名字
//        System.out.println(f.getClass());     得到变量f的类型
//        System.out.println(f.exists());       判断文件是否存在
        String content = GetContent(f);
//        System.out.println(content.replace(" ",""));
//        System.out.println(content.replace(",",""));
        content = content.replace(","," ");
        System.out.println(content);
        content = content.replace(".","");
        System.out.println(content);
//        ArrayList list = new ArrayList(Arrays.asList(content.split(" ")));   String 转 ArrayList类型
//        System.out.println(list);
        //大写转为小写
        content = content.toLowerCase();   // 转为大写的函数是toUpperCase
        String[] ids = content.split(" ");            // String 转 String[]类型
        bubbleSort(ids);
//        for (String tmp: ids
//             ) {
//            System.out.print(tmp + " ");
//        }
        InputContent(ids,f);
    }
}
