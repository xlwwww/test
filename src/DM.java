import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class DM {
    public static String[][] readCSV() {
        String[][] item = null;
        try {
            // 用来保存数据
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 定义一个CSV路径
            String csvFilePath = "C:\\Users\\dushu\\Desktop\\QCM Sensor Alcohol Dataset\\QCM12.csv";
            // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            reader.readHeaders();
            // 逐行读入除表头的数据
            while (reader.readRecord()) {
                System.out.println(reader.getRawRecord());
                csvFileList.add(reader.getValues());
            }
            reader.close();
            // 遍历读取的CSV文件
            item = new String[csvFileList.size()][15];
            for (int row = 0; row < csvFileList.size(); row++) {
                // 取得第row行第0列的数据
                String cell = csvFileList.get(row)[0];
                item[row] = cell.split(";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }
    public static void writeCSV(String[][] item) {
        // 定义一个CSV路径
        String csvFilePath = "C:\\Users\\dushu\\Desktop\\QCM Sensor Alcohol Dataset\\myQCM12.csv";
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
            String[] csvHeaders = { "Concentration1", "Concentration2", "Concentration3", "Concentration4", "Concentration5","MIPratio","NPratio","Alcohol"};
            csvWriter.writeRecord(csvHeaders);
            // 写内容
            String[] label = new String[]{"1-octanol","1-propanol","2-butanol", "2-propanol","1-isobutanol"};
            for (int i = 0; i < item.length; i++) {
                String part1 = String.valueOf((Double.parseDouble(item[i][0])+Double.parseDouble(item[i][1]))/2);
                String part2 = String.valueOf((Double.parseDouble(item[i][2])+Double.parseDouble(item[i][3]))/2);
                String part3 = String.valueOf((Double.parseDouble(item[i][4])+Double.parseDouble(item[i][5]))/2);
                String part4 = String.valueOf((Double.parseDouble(item[i][6])+Double.parseDouble(item[i][7]))/2);
                String part5 = String.valueOf((Double.parseDouble(item[i][8])+Double.parseDouble(item[i][9]))/2);
                String part6 = "0";
                String part7 = "1";
                String part8 = "";
                for(int j = 10;j<15;j++){
                    if(item[i][j].equals("1")){
                        part8 = label[j-10];
                        break;
                    }
                }
                String[] csvContent = { part1,part2,part3,part4,part5,part6,part7,part8};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("--------CSV文件已经写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String[][] item =  readCSV();
        writeCSV(item);
    }
}
