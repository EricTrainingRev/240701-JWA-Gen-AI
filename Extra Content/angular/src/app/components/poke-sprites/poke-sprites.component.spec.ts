import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PokeSpritesComponent } from './poke-sprites.component';
import { PokemonService } from 'src/app/services/pokemon.service';

import pokemonFixture from '../../fixtures/pokemonFixture.json';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

describe('PokeSpritesComponent', () => {
  let component: PokeSpritesComponent;
  let fixture: ComponentFixture<PokeSpritesComponent>;
  let pokeService: PokemonService;
  let mockHttp: HttpTestingController;
  const mockPokemon = pokemonFixture.pokemon;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PokeSpritesComponent],
      imports: [HttpClientTestingModule],
      providers: [PokemonService]
    });
    fixture = TestBed.createComponent(PokeSpritesComponent);
    component = fixture.componentInstance;
    pokeService = TestBed.inject(PokemonService);
    mockHttp = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the div that contains sprite images in the img elements', () =>{
    component.pokemonSprites = mockPokemon.sprites;
    fixture.detectChanges();
    const divElement: HTMLElement = fixture.debugElement.query(By.css('div')).nativeElement;
    expect(divElement.style.display).not.toBe("none");

  });

  it('should render the img element with the source provided in the sprites list', () =>{
    component.pokemonSprites = mockPokemon.sprites;
    fixture.detectChanges();
    const imgDebugElements: DebugElement[] = fixture.debugElement.queryAll(By.css('img'));
    for (let debugElement of imgDebugElements){
      expect(debugElement.nativeElement.style.display).not.toBe("none");
    }
  });
});
