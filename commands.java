spark-shell

pyspark
  

  scala> val a=10
a: Int = 10

scala> println(a)


>>> a=10
>>> print(a)


sc.appName

val rdd1=sc.textFile("c:/test/first.txt")
rdd1.collect()


>>> rdd1=sc.textFile("c:/test/first.txt")
>>> rdd1.collect()

scala> val rdd2=sc.textFile("c:/test")
rdd2: org.apache.spark.rdd.RDD[String] = c:/test MapPartitionsRDD[7] at textFile at <console>:24

scala> rdd2.collect


 val rdd3=sc.textFile("c:/test/first.txt,c:/next/sample.txt")
 
 rdd3.collect
 
 
<dependencies>
  <!-- https://mvnrepository.com/artifact/org.apache.spark/spark-core -->
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-core_2.12</artifactId>
    <version>3.0.3</version>
</dependency>
  
  </dependencies>
  
  project: SparkCorePrj
  package: com.jpmc.training.sparkcore
  class: RDDCreationTest
  
package com.jpmc.training.sparkcore;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDCreationTest {
    public static void main(String[] args) {
        SparkConf conf=new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName("rdd-creation-app");
        
        JavaSparkContext sc=new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        
        JavaRDD<String> rdd1=sc.textFile("c:/test/first.txt");
        List<String> list=rdd1.collect();
        list.forEach(System.out::println);
    }

}


scala> val rdd1=sc.textFile("c:/test/first.txt")
rdd1: org.apache.spark.rdd.RDD[String] = c:/test/first.txt MapPartitionsRDD[11] at textFile at <console>:24

scala> rdd1.count()

scala> val list=List(3,6,10,5)
list: List[Int] = List(3, 6, 10, 5)

scala> val rdd1=sc.parallelize(list)
rdd1: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[12] at parallelize at <console>:26

scala>

scala> rdd1.collect();

package com.jpmc.training.sparkcore;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDCreationTest2 {
    public static void main(String[] args) {
        SparkConf conf=new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName("rdd-creation-app");
        
        JavaSparkContext sc=new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        
        List<Integer> list=Arrays.asList(2,5,15,10,12);
        JavaRDD<Integer> rdd1=sc.parallelize(list);
        rdd1.collect().forEach(System.out::println);
        sc.close();
    }

}
  
 rdd1.take(2)
 
 scala> val rdd2=rdd1.map(elt=>elt.toUpperCase)
rdd2: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[27] at map at <console>:25

scala> rdd2.collect

>>> rdd2=rdd1.map(lambda x:x.upper())
>>> rdd2.collect()


scala> val rdd3=rdd2.filter(line=>line.startsWith("S"))
rdd3: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[28] at filter at <console>:25

scala> rdd3.collect


scala> val rdd1=sc.textFile("c:/test/first.txt")
rdd1: org.apache.spark.rdd.RDD[String] = c:/test/first.txt MapPartitionsRDD[30] at textFile at <console>:24

scala> val rdd3=rdd1.map(line=>line.toUpperCase()).filter(line=>line.startsWith("S"))
rdd3: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[32] at filter at <console>:25

scala> rdd3.collect

rdd1.map(lambda x:x.upper()).filter(lambda x:x.startswith("S")).collect()

package com.jpmc.training.sparkcore;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDTransformationTest {
    public static void main(String[] args) {
        SparkConf conf=new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName("rdd-transformation-test-app");
        
        JavaSparkContext sc=new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        
        JavaRDD<String> rdd1=sc.textFile("c:/test/first.txt");
        List<String> list=rdd1.map(line->line.toUpperCase()).filter(line->line.startsWith("S")||line.startsWith("T")).collect();
        list.forEach(System.out::println);
        sc.close();
    }

}

scala> val rdd1=sc.textFile("c:/test/first.txt")
rdd1: org.apache.spark.rdd.RDD[String] = c:/test/first.txt MapPartitionsRDD[38] at textFile at <console>:24

scala> val rdd2=rdd1.map(line=>line.split(" "))
rdd2: org.apache.spark.rdd.RDD[Array[String]] = MapPartitionsRDD[39] at map at <console>:25

scala> rdd2.collect()
res27: Array[Array[String]] = Array(Array(this, is, a, test, file), Array(used, to, create, spark, rdd), Array(spark, is, interesting), Array(scala, is, fun), Array(dffffffffffffffff), Array(xxxxxxxxxxxx))

scala> val rdd3=rdd1.flatMap(line=>line.split(" "))
rdd3: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[40] at flatMap at <console>:25

scala> rdd3.collect()



https://drive.google.com/drive/folders/1B9xTgQXAwtA5Osx-87MHZewKOiK_hMbh?usp=sharing

