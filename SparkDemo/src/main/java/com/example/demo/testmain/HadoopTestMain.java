package com.example.demo.testmain;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HadoopTestMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url="hdfs://192.168.44.128:9000";
        //创建Configuration
        Configuration conf=new Configuration();
        conf.set("fs.defaultFS", url);

        //创建FileSystem对象
        FileSystem fs=FileSystem.get(conf);
        // 需求：查看/user/kevin/passwd的内容
        FSDataInputStream is=fs.open(new Path(url+"/qiguai/hadoop/text.txt"));
        byte[] buff=new byte[1024];
        int length=0;
        while((length=is.read(buff))!=-1){
            System.out.println(new String(buff,0,length));
        }
    }
}
