package java刘意.exception;

public class TeacherException {

    public void checkScore(int score) throws ExceptionDemo2 {
        if(score<0||score>100){
//            throw new ExceptionDemo2();
            throw new ExceptionDemo2("你给的分数有误，分数在0-100之间");
        }else {
            System.out.println("分数正常");
        }
    }

}
