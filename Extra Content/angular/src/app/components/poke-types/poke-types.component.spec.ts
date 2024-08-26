import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

import { PokeTypesComponent } from './poke-types.component';
import { PokemonService } from 'src/app/services/pokemon.service';

import pokemonFixture from '../../fixtures/pokemonFixture.json';
import { By } from '@angular/platform-browser';

describe('PokeTypesComponent', () => {
  let component: PokeTypesComponent;
  let fixture: ComponentFixture<PokeTypesComponent>;
  let pokeService: PokemonService;
  let httpMock: HttpTestingController;
  let mockPokemon = pokemonFixture.pokemon;


  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PokeTypesComponent],
      imports: [HttpClientTestingModule],
      providers: [PokemonService]

    });
    fixture = TestBed.createComponent(PokeTypesComponent);
    component = fixture.componentInstance;
    pokeService = TestBed.inject(PokemonService);
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // not technically a true unit test, but I don't care XD
  it('should update the types list when a new pokemon is loaded', () => {
    pokeService.pokemon = mockPokemon;
    pokeService.getPokemonSubject().next(pokeService.pokemon);
    expect(fixture.componentInstance.pokemonTypes).toEqual(mockPokemon.types);
  });

  it('should render text color based on the name of the pokemon types', ()=> {
    const keys = Object.keys(fixture.componentInstance.typesObject);
    for(let key of keys){
      fixture.componentInstance.pokemonTypes = [key];
      fixture.detectChanges();
      let elementColor = fixture.debugElement.query(By.css("li")).nativeElement.style.color;
      let convertHexToRGB = (hex:string) => {
          const r = parseInt(hex.substring(1, 3), 16);
          const g = parseInt(hex.substring(3, 5), 16);
          const b = parseInt(hex.substring(5, 7), 16);
          return `rgb(${r}, ${g}, ${b})`;
      }
      expect(convertHexToRGB(fixture.componentInstance.typesObject[key])).toBe(elementColor);
    }
  });
});
