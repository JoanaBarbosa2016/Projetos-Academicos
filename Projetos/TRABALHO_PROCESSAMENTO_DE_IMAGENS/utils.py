#!-*- conding:  iso8859-1 -*-
import cv2
import  numpy as np

class Utils():

    def __init__(self):
        print('teste')
        
    def blendingTwoImages(self, imagem1, imagem2, peso):
        imagem1 = cv2.imread(imagem1)
        imagem2 = cv2.imread(imagem2)
        [y, x, c] = imagem2.shape
        imagem1 = cv2.resize(imagem1, (x, y))
        imgDst = cv2.addWeighted(imagem1, peso, imagem2, 1-peso, 0)
        cv2.imshow("dst", imgDst)
        cv2.waitKey(0)

    def extraRegionOfInterest(self, image, xMin, xMax, yMin, yMax):
        image2 = []
        image2 = image[xMin:xMax, yMin:yMax]
        cv2.imwrite("NovaBola.jpg", image2)
        cv2.imshow("Magica", image2)
        cv2.waitKey(0)
        
