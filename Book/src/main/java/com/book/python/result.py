import findspark
from pyspark import SparkContext

from pyspark.mllib.recommendation import MatrixFactorizationModel


def getRecommendByUserId(userId, rec_num):
    try:
        model = MatrixFactorizationModel.load(sc, 'recommendModel')
        result = model.recommendProducts(userId, rec_num)
        temp = ''
        for r in result:
            temp += str(r[0]) + ',' + str(r[1]) + ',' + str(r[2]) + '|'
        print(temp)
        print('load model success !')
    except Exception as e:
        print('load model failed!' + str(e))

findspark.init()
sc = SparkContext()
getRecommendByUserId(17, 2)
sc.stop()
