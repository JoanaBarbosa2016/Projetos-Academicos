#!-*- conding:  iso8859-1 -*-
import numpy as np
import cv2
import image
import utils as ut

#class SuperImage:
 #   ImageInstance = Image()
  #  UtilsInstance = Utils()

#processamento = image.Image ("Juma.jpg")
#print (processamento.openBWImage())
#================================================================#
##processamento1 = image.Image ("Bolsonaro.jpg")
##print (processamento1.openColoredImage())
###================================================================#
##processamento2 = image.Image("Bolsonaro.jpg")
##print (processamento2.saveImage())
###================================================================#
##processamento3 = image.Image( "NovaBolsonaro_Final.jpg")
##print( processamento3.saveInDifferentPath())
###================================================================#
##processamento4 = image.Image( "Lena_Colorida.png")
##print (processamento4.turnColoredImageIntoBW())
###================================================================#
ut.Utils.blendingTwoImages(ut.Utils(), "Bolsonaro.jpg", "Temer.jpg", 0.5)
###================================================================#
##processamento6 = image.Image("Juma.jpg")
##print (processamento6.setImage(self, 20, 100, 3, 255))
###================================================================#
#processamento7 = utils.Utils("bola.jpg")
##print (processamento7.extraRegionOfInterest(self, 400, 775, 520, 660))
