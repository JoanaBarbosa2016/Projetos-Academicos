#!-*- conding:  iso8859-1 -*-
import cv2
import numpy as np

class Image():


    
    def __init__(self, imagem):
        pass
        self.path = ""
        self.image = []

    def openBWImage (self):
        self.imagem = cv2.imread("Juma.jpg", 0)
        cv2.imshow("Juma em Preto e Branco", imagem)
        cv2.waitKey(0)

    def openColoredImage(self, path):
        self.imagem = cv2.imread(path, 1)
        self.path = path
        cv2.imshow("Bolsonaro para Presidente em 2018", imagem)
        cv2.waitKey(0)

    def saveImage(self, path):
       cv2.imwrite(path, self.imagem)

    def saveInDifferentPath(self, newPath):
       cv2.imwrite(newPath, imagem)

    def setColor(self, positionX, positionY, channel, value):
        imagem = cv2.imread('Juma.jpg')
        imagem[positionY,positionX, channel] = value
        cv2.imshow("Juminha gatinha", imagem);
        cv2.waitKey(0)

    def turnColoredImageIntoBW(self):
         imagem = cv2.imread("LenaColorida.png")
         imagem1 = cv2.imread("LenaColorida.png", cv2.IMREAD_GRAYSCALE);
         cv2.imshow("Lena Antes da Transformacao", imagem)
         cv2.imshow("Lena Em Tons de Cinza", imagem1)
         cv2.waitKey(0)
