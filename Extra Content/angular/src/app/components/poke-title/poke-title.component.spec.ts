import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';

import { PokeTitleComponent } from './poke-title.component';
import { By } from '@angular/platform-browser';
import { PokemonService } from 'src/app/services/pokemon.service';
import { Pokemon } from 'src/app/interfaces/pokemon';

// to make this import work I had to update the tsconfig.json file: see comment in compiler there
import pokemonFixture from "../../fixtures/pokemonFixture.json";

describe('PokeTitleComponent', () => {
  let component: PokeTitleComponent;
  let fixture: ComponentFixture<PokeTitleComponent>;
  let pokemonService: PokemonService;
  let httpMockService: HttpTestingController
  let mockPokemon: Pokemon;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PokeTitleComponent],
      imports: [HttpClientTestingModule],
      providers:[PokemonService]
    });
    fixture = TestBed.createComponent(PokeTitleComponent);
    component = fixture.componentInstance;
    pokemonService = TestBed.inject(PokemonService);
    httpMockService = TestBed.inject(HttpTestingController);
    fixture.detectChanges();

    mockPokemon = pokemonFixture.pokemon;

    // mockPokemon = {
    //   name: 'pikachu',
    //   sprites: ['source-one', 'source-two'],
    //   types: ['electric'],
    //   moves: ['thunderbolt', 'thunder', 'mega-punch'],
    // };
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the div holding the h2 element', ()=>{
    component.pokemon = mockPokemon;
    fixture.detectChanges();
    const h2Container: HTMLElement = fixture.debugElement.query(By.css('div')).nativeElement;
    expect(h2Container.style.display).not.toBe("none");
  });

  it('should show the pokemon name in the h2 element', () => {
    component.pokemon = mockPokemon;
    fixture.detectChanges();
    const h2Element: HTMLElement = fixture.debugElement.query(By.css('h2')).nativeElement;
    expect(h2Element.textContent).toContain("Pikachu");
  });
});
