package hadoop01;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



	// Mapper类
    public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{
        
        // new一个值为1的整数对象 
        private final static IntWritable one = new IntWritable(1);
        // new一个空的Text对象
        private Text word = new Text();
      
        //每次调用map方法会传入split中一行数据，key：该行数据所在文件中的位置下标，value：这行数据
        //context作输出用的
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            
            // 创建value的字符串迭代器,以空格进行分割
            StringTokenizer itr = new StringTokenizer(value.toString());
        
            // 对数据进行再次分割并输出map结果。初始格式为<字节偏移量，单词> 目标格式为<单词，频率>
            while (itr.hasMoreTokens()) {
                    word.set(itr.nextToken());
                    context.write(word, one);//map的输出
            }
        }
    }
        

