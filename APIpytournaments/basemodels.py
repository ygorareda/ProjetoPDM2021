from typing import List, Optional
from pydantic import BaseModel
from decimal import Decimal


class Game(BaseModel):
    id: int
    name: str
    genre: str
    description: str



class User(BaseModel):
    id : str
    name: str
    username: str
    # preferencesOfGames :  Optional[List[str]]
    # tournamentsParticipated : Optional[List[str]]
    # tournamentsSubscribed: Optional[List[str]]

class Location(BaseModel):
    lat : Optional[Decimal]
    lng : Optional[Decimal]

class Tournaments(BaseModel):
    name: str
    description: str
    date: str
    #time :str
    location : Location
    owner : str
    game : str
    user : str
    #participants : List[User]
    #isparticipant : bool
    # winnerOrder : List[User]








    