# 文件上传
# 将mysql驱动包放到spark的jars下
def main(a):
    data = spark.read.csv(a)
    data = data.toPandas().drop([0])
    data.columns = ['id', 'name', 'score', 'price', 'publish', 'url']
    data = spark.createDataFrame(data)
    data = data.select("name", "score", "price", "publish", "url")
    prop = {
        'user': 'root',
        'password': '1513',
        'driver': 'com.mysql.cj.jdbc.Driver'
    }
    url = 'jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false'
    data.write.jdbc(url=url, table='book', mode='append', properties=prop)
    data.write.jdbc(url=url, table='book_test', mode='append', properties=prop)
    return "end upload"


if __name__ == '__main__':
    print("开始上传")
    import sys
    import findspark
    findspark.init()
    from pyspark.sql import SparkSession
    spark = SparkSession.builder.getOrCreate()
    for i in range(1, len(sys.argv)):
        path = sys.argv[i]
        result = main(path)
        print(result)
    spark.stop()
    print("已上传")
