def getRecommendByUserId(userId, rec_num):
    try:
        model = MatrixFactorizationModel.load(sc, 'D:\\IDEA\\study\\keshe\\Book\\src\\main\\java\\com\\book\\python\\recommendModel')
        result = model.recommendProducts(userId, rec_num)
        temp = ''
        for r in result:
            temp += str(r[0]) + ',' + str(r[1]) + ',' + str(r[2]) + '|'
        return temp
    except Exception as e:
        print('load model failed!' + str(e))


if __name__ == '__main__':
    import sys
    import findspark
    findspark.init()
    from pyspark import SparkContext
    sc = SparkContext()
    from pyspark.mllib.recommendation import MatrixFactorizationModel
    recommend = getRecommendByUserId(int(sys.argv[1]), int(sys.argv[2]))
    print(recommend)
    sc.stop()
