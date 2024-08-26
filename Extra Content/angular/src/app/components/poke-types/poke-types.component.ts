import { Component, OnInit } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-poke-types',
  templateUrl: './poke-types.component.html',
  styleUrls: ['./poke-types.component.css'],
})
export class PokeTypesComponent {
  pokemonTypes: string[] = this.pokeService.pokemon.types;

  typesObject: { [key: string]: string } = {
    bug: '#A8B820', // strong yellow
    dark: '#705848', // dark brownish-grey
    dragon: '#7038F8', // vibrant purple-blue
    electric: '#F8D030', // bright yellow
    fairy: '#EE99AC', // light pinkish-purple
    fighting: '#C03028', // deep red
    fire: '#F08030', // bright orange
    flying: '#A890F0', // light blueish-purple
    ghost: '#705898', // dark purple-grey
    grass: '#78C850', // vibrant green
    ground: '#E0C068', // earthy yellow-brown
    ice: '#98D8D8', // icy light blue
    normal: '#A8A878', // greyish-tan
    poison: '#A040A0', // deep purple-pink
    psychic: '#F85888', // bright pink-red
    rock: '#B8A038', // brownish-yellow-grey
    steel: '#B8B8D0', // light grey-blue
    water: '#6890F0', // deep blue
  };

  constructor(private pokeService: PokemonService) {}

  ngOnInit() {
    this.pokeService.getPokemonSubject().subscribe((pokemon) => {
      this.pokemonTypes = pokemon.types;
    });
  }
}
