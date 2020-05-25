package com.example.demo.testmain;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SparkMainTest {
    public static void main(String[] args) {
        //创建SparkConf对象
        SparkConf conf=new SparkConf();
        conf.setAppName("WordCount");
        conf.setMaster("local");

        //创建java sc
        JavaSparkContext sc=new JavaSparkContext(conf);
        //加载文本文件
        //JavaRDD<String> rdd=sc.textFile("D:\\MyWork\\JavaWorkspace\\demo\\SparkDemo\\src\\main\\resources\\testfile\\wordcount.txt");
        JavaRDD<String> rdd=sc.textFile("hdfs://192.168.44.128:9000/qiguai/hadoop/text.txt");
        //压扁
        JavaPairRDD<String,Integer> rdd2=rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                List<String> list=new ArrayList<String>();
                String[] arr=s.split(" ");
                for(String ss:arr){
                    list.add(ss);
                }
                return list.iterator();
            }
        }).mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String,Integer>(s,1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }
        });

        Map<String,Integer> map=rdd2.collectAsMap();

        for(String key:map.keySet()) System.out.println(key+"："+map.get(key));



    }
}
