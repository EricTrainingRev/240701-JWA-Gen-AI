import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/interfaces/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-poke-sprites',
  templateUrl: './poke-sprites.component.html',
  styleUrls: ['./poke-sprites.component.css']
})
export class PokeSpritesComponent {

  pokemonSprites : string[] = this.pokeService.pokemon.sprites;

  constructor(private pokeService: PokemonService){}

  ngOnInit(){
    this.pokeService.getPokemonSubject().subscribe(pokemon => {
      this.pokemonSprites = pokemon.sprites;
    });
  }

}
