package hadoop01;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
// 主类
public class JobRun {
// 主函数
	//要在liunx中去运行jar；步骤：从eclipse中Export打包到liunx中，再cd /home/hadoop-2.8/bin中运行./hadoop jar /jar的路径.主类
    public static void main(String[] args) throws IOException {
  
        // 获取配置参数
        Configuration conf = new Configuration();
        conf.set("mapred.job.tracker", "192.168.11.130:9001");
        
    	 // 判断output文件夹是否存在，如果存在则删除
        Path path = new Path("/output/");// 取第1个表示输出目录参数（第0个参数是输入目录）
        FileSystem fileSystem = path.getFileSystem(conf);// 根据path找到这个文件
        if (fileSystem.exists(path)) {
        	fileSystem.delete(path, true);// true的意思是，就算output有东西，也一带删除
        }
        try{
        Job job=new Job(conf);
        job.setJarByClass(JobRun.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(IntSumReducer.class);
        
        //job.setNumReduceTasks(1);//设置reduce任务的个数
        
        // 设置输入输出路径
        FileInputFormat.addInputPath(job, new Path("/input/"));
        FileOutputFormat.setOutputPath(job, new Path("/output/"));
                
        // 运行程序
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
    }
}