package hadoop01;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


//Reducer类
public class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    // new一个值为空的整数对象
    private IntWritable result = new IntWritable();

    // 实现reduce函数
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
            
        // 得到本次计算的单词的频数
        result.set(sum);
                    
        // 输出reduce结果
        context.write(key, result);
    }
}
