import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MonolithicViewComponent } from './components/monolithic-view/monolithic-view.component';
import { SearchComponent } from './components/search/search.component';
import { PokeTypesComponent } from './components/poke-types/poke-types.component';
import { PokeTitleComponent } from './components/poke-title/poke-title.component';
import { PokeSpritesComponent } from './components/poke-sprites/poke-sprites.component';
import { PokeMovesComponent } from './components/poke-moves/poke-moves.component';

const routes: Routes = [
  {
    path: '',
    component: MonolithicViewComponent,
  },
  {
    path: 'search',
    component: SearchComponent,
  },
  {
    path: 'name',
    component: PokeTitleComponent,
  },
  {
    path: 'sprites',
    component: PokeSpritesComponent,
  },
  {
    path: 'types',
    component: PokeTypesComponent,
  },
  {
    path: 'moves',
    component: PokeMovesComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
