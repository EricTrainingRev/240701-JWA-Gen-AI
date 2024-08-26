import { Component, EventEmitter, Input, Output, ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-moves-filter',
  templateUrl: './moves-filter.component.html',
  styleUrls: ['./moves-filter.component.css']
})
export class MovesFilterComponent {

  filterValue : string = "";

  @Input()
  allMoves: string[] = [];

  filteredMoves: string[] = [];

  @Output()
  moveExporter : EventEmitter<string[]> = new EventEmitter<string[]>();

  constructor(){

  }

  printFilterList(event : any){
    console.log(event.target.value);
  }

  filterMoves(){
    if(this.filterValue == ""){
      return this.allMoves;
    } else {
      this.filteredMoves = [];
      for(let move of this.allMoves){
        if(move.includes(this.filterValue)){
          this.filteredMoves.push(move);
        }
      }
      return this.filteredMoves;
    }
  }

  exportMoves(event : any){
    this.moveExporter.emit(this.filterMoves());
  }

}
