import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pokemon } from '../interfaces/pokemon';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  pokemon : Pokemon = {
    name:"",
    sprites:[],
    types:[],
    moves:[]
  }

  pokemonSubject : Subject<Pokemon> = new Subject<Pokemon>();

  constructor(private httpClient: HttpClient) { }

  getPokemonSubject(){
    return this.pokemonSubject;
  }

  getPokemon(id : String){
    return this.httpClient.get(`https://pokeapi.co/api/v2/pokemon/${id}`);
  }

  updatePokemon(pokemonData: any){
    this.setPokemonName(pokemonData);
    this.setPokemonSprites(pokemonData);
    this.setPokemonTypes(pokemonData);
    this.setPokemonMoves(pokemonData);
    this.pokemonSubject.next(this.pokemon);
  }

  setPokemonName(pokemonData: any){
    this.pokemon.name = pokemonData.name;
    console.log(this.pokemon.name);
  }

  setPokemonSprites(pokemonData: any){
    this.pokemon.sprites = [];
    for (let key in pokemonData.sprites){
      if (typeof pokemonData.sprites[key] == "string"){
        this.pokemon.sprites.push(pokemonData.sprites[key]);
      }
    }
    console.log(this.pokemon.sprites);
  }

  setPokemonTypes(pokemonData: any){
    this.pokemon.types = [];
    for (let typeObject of pokemonData.types){
      this.pokemon.types.push(typeObject.type.name);
    }
    console.log(this.pokemon.types);
  }

  setPokemonMoves(pokemonData: any){
    this.pokemon.moves = [];
    for (let pokemonMoveObject of pokemonData.moves){
      this.pokemon.moves.push(pokemonMoveObject.move.name);
    }
    console.log(this.pokemon.moves);
  }
}
