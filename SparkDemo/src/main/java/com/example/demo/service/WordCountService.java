package com.example.demo.service;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCountService {
    @Autowired
    private SparkContext sparkContext;
    @Autowired
    private SparkSession sparkSession;


}
