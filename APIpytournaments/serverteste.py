from basemodels import User, Game ,Tournaments
import json
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

from fastapi import Depends, FastAPI
from pydantic import BaseModel
from routers import routesUsers,routesTournaments



#cria o CRUD
app = FastAPI()

app.include_router(routesUsers.router)
app.include_router(routesTournaments.router)



# @app.get("/cadastra")
# def cadastra(usuario : User):
#     ref.push({
#         usuario.nome :{
#             "idade" : usuario.idade,
#             "sobrenome" : usuario.sobrenome
#         }


#     })

