import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;
public class Test {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期");
        //传入IO流对象
        Scanner sc = new Scanner(System.in);
        String cxt = sc.nextLine();
        System.out.println("您刚输入的日期是"+cxt);
        //将字符串格式转换为date对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(cxt);
        //将date对象转换为calendar对象
        Calendar calendar  = new GregorianCalendar();
        calendar.setTime(date);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//获取月份天数
        int myday = calendar.get(Calendar.DATE);//获得该日期的日子
        calendar.set(Calendar.DATE,1);//设置为本月1号
        int row = calendar.get(Calendar.DAY_OF_WEEK);//本月1号的星期数
        int tmp = row;
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        while (tmp>1){
            System.out.print("\t");
            tmp -=1;
        }
        for(int i =1; i<=days;i++){
            if (i == myday){
                System.out.print(i+"*"+"\t");
            } else {
                System.out.print(i+"\t");
            }
            row +=1;
            if (row>7){
                row = 1;
                System.out.println();
            }
        }

    }
}
