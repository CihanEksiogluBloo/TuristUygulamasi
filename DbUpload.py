import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
import json

cred = credentials.Certificate("C:/Users/Cihan/Desktop/datas/service-account-file.json")
firebase_admin.initialize_app(cred)

db = firestore.client()

with open('C:/Users/Cihan/Desktop/datas/data.json',encoding="utf8") as f:
  data = json.load(f)

for i in list(range(0, len(data))):
    json_dump = json.dumps(data[i])
    json_object = json.loads(json_dump)


    sehir = json_object['Sehir'] + 'FoodsDatas'
    yemekBelgeisim = json_object['Foods'] + ' Documents'
    doc_ref = db.collection(sehir).document(yemekBelgeisim)
    doc_ref.set({
    u'x': json_object['x'],
    u's': json_object['s'],
    u'a': json_object['a'],
    u'd': json_object['d'],
    u'f': json_object['f'],
    u'g': json_object['g'],
    u'h': json_object['h']

    })