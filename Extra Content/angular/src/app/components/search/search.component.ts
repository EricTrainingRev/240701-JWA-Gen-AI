import { Component } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  pokeId: String = ""

  constructor(private pokemonService: PokemonService){}

  searchPokemon(){
    let pokemonObservable = this.pokemonService.getPokemon(this.pokeId)
    pokemonObservable.subscribe(data => {
      this.pokemonService.updatePokemon(data);
    });
  }

}
