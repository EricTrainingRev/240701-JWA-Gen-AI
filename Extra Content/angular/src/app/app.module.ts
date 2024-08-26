import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchComponent } from './components/search/search.component';
import { PokeTitleComponent } from './components/poke-title/poke-title.component';
import { MonolithicViewComponent } from './components/monolithic-view/monolithic-view.component';
import { PokeSpritesComponent } from './components/poke-sprites/poke-sprites.component';
import { PokeTypesComponent } from './components/poke-types/poke-types.component';
import { PokeMovesComponent } from './components/poke-moves/poke-moves.component';
import { MovesFilterComponent } from './components/poke-moves/moves-filter/moves-filter.component';
import { DashRemoverPipe } from './pipes/dash-remover.pipe';
import { UppercaseWordsPipe } from './pipes/uppercase-words.pipe';
import { BoxStylingDirective } from './directives/box-styling.directive';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    PokeTitleComponent,
    MonolithicViewComponent,
    PokeSpritesComponent,
    PokeTypesComponent,
    PokeMovesComponent,
    MovesFilterComponent,
    DashRemoverPipe,
    UppercaseWordsPipe,
    BoxStylingDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
