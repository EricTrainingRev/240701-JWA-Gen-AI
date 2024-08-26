import { Component, OnInit, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { Pokemon } from 'src/app/interfaces/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-poke-moves',
  templateUrl: './poke-moves.component.html',
  styleUrls: ['./poke-moves.component.css'],
})
export class PokeMovesComponent implements OnInit {

  moveTextAlignmentStyling: string = 'justify';

  allMoves : string[] = this.pokeService.pokemon.moves;

  moveDisplayList: string[] = this.allMoves;

  constructor(private pokeService: PokemonService) {}

  ngOnInit(){
    this.pokeService.getPokemonSubject().subscribe(pokemon => {
      this.allMoves = pokemon.moves;
      this.moveDisplayList = this.allMoves;
    });
  }

  updateDisplayList($data : any){
    this.moveDisplayList = $data;
  }

}
