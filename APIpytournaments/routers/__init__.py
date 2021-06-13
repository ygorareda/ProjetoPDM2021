
import json
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

#inicializa o firebase

cred = credentials.Certificate("/home/ygor/pytournaments/pytournaments/pytournaments-8feef-firebase-adminsdk-o9mcw-5a6f73a940.json")
#cred = credentials.Certificate("C:/Users/ygor.areda/Desktop/repositorios/teste_firebaseDB/pytournaments/pytournaments/pytournaments-8feef-firebase-adminsdk-o9mcw-5a6f73a940.json")
firebase_admin.initialize_app(cred, {
    'databaseURL' : "https://pytournaments-8feef-default-rtdb.firebaseio.com/"
})