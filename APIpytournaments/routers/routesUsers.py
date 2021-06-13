from basemodels import User, Game ,Tournaments
import json
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

from fastapi import APIRouter
from pydantic import BaseModel


#inicializa o banco de dados



ref = db.reference('/users')
ref2 = db.reference("/games")
ref3 = db.reference("/friends")
ref4 = db.reference("/tournaments")


#cria o CRUD
router = APIRouter(
    prefix = "/users",
    tags=["users"]
)

#busca geral
@router.get("/busca/geral")
async def busca():

    saida = ref.order_by_key().get()
    listasaida=[]
    for s in saida.items():
        listasaida.append(s[1])

    return listasaida

        
@router.get("/busca/amigos")
async def getFriends(id : str):

    listOfFriends = []
    saida = ref3.order_by_key().equal_to(id).get()

    for item in saida.items():
        for i in item[1].items():
            if i[1] == True:
                listOfFriends.append(buscaUser(i[0]))
                

    
    return listOfFriends



@router.post("/cadastra")
def cadastra(usuario : User):



    #pega os torneios do qual participa
    # participated = []
    # for tournament in usuario.tournamentsParticipated:
    #     actualTournament = ref4.order_by_child("name").equal_to(tournament).get()
    #     if actualTournament :
    #         for a in actualTournament.items():
    #             participated.append(a[0])

    #print(participated)
    

    #cadastra o usuário
    cadUser = ref.push({
        "id": usuario.id,
        "name": usuario.name,
        "username": usuario.username
        # "email": usuario.email,
        # "preferencesOfGames" : usuario.preferencesOfGames,
        # "tournamentsParticipated" : participated,
        # "tournamentsSubscribed": usuario.tournamentsSubscribed

    })

    #print(teste.key)

    #inicia sua lista de amigos    
    ref3.update({
        usuario.id :{
            usuario.id : False
        }
    })

    return "Cadastrado com sucesso"

@router.post("/cadastra/amigo")
async def cadastraAmigo(idUser: str, idFriend: str):
    
    userToadd = ref3.child(idUser)
    userToadd.update({
        idFriend: True
    })

    userToadd = ref3.child(idFriend)
    userToadd.update({
        idUser: True
    })
    
    return "certinho"





@router.delete("/deleta")
async def delete(id : int):

    teste = ref.order_by_child("id").equal_to(id).get()
    for s in teste.items():
        ref.child(s[0]).delete()

        return "o usuário deletado"


@router.post("/user")
async def getUser(id : str):

    return buscaUser(id)


def buscaUser(id : str):
    user = ref.order_by_child("id").equal_to(id).get()

    for item in user.items():
        return item[1]
        
 
