import { Component } from '@angular/core';
import { Pokemon } from 'src/app/interfaces/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-poke-title',
  templateUrl: './poke-title.component.html',
  styleUrls: ['./poke-title.component.css']
})
export class PokeTitleComponent {

  pokemon : Pokemon = this.pokeService.pokemon;

  constructor(private pokeService: PokemonService){}

}
