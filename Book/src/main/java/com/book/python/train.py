import os
import shutil
import findspark
findspark.init()
from pyspark.sql import SparkSession
from pyspark.mllib.recommendation import ALS

spark = SparkSession.builder.getOrCreate()
prop = {
    'user': 'root',
    'password': '1513',
    'driver': 'com.mysql.cj.jdbc.Driver'
}
url = 'jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false'
data = spark.read.jdbc(url=url, table='hit', properties=prop)
data = data.select("userId", "bookId", "hit")
data.createOrReplaceTempView("hits")
datatable = spark.sql("select userId,bookId,sum(hit) as hitnums from hits group by userId,bookId")
hitsrdd = datatable.rdd.map(lambda x: (x.userId, x.bookId, x.hitnums))
model = ALS.trainImplicit(hitsrdd, 10, 10, 0.01)

if os.path.exists('recommendModel'):
    shutil.rmtree('recommendModel')
model.save(spark.sparkContext, 'recommendModel')
spark.stop()
