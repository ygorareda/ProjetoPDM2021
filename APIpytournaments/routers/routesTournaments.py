from basemodels import Tournaments
import json
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

from fastapi import APIRouter
from pydantic import BaseModel

#inicializa o banco de dados



ref = db.reference('/tournaments')
ref2= db.reference('/users')

#cria o CRUD
router = APIRouter(
    prefix = '/tournaments',
    tags =["tournaments"]
)




#busca geral
@router.get("/busca")
async def busca():

    saida = ref.get()
    return saida


@router.post("/cadastra")
def cadastra(tournament : Tournaments):


    #busca e cadastra participantes no torneio
    # listaParticipantes =[]
    # for participant in tournament.participants:
    #     actualParticipant = ref2.order_by_child("name").equal_to(participant).get()
    #     if actualParticipant:
    #         for a in actualParticipant.items():
    #             listaParticipantes.append(a[0])

    # print(listaParticipantes)


    ref.push({
        "name" : tournament.name,
        "description": tournament.description,
        "date": tournament.date,
        #"time" : tournament.time,
        "location" :{
            "lat" : tournament.location.lat,
            "lng" : tournament.location.lng
        },
        "owner": tournament.owner,
        "game": tournament.game,
        "user": tournament.user
        
    })

    return "deu certo"