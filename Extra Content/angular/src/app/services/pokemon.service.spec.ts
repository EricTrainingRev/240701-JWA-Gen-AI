import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PokemonService } from './pokemon.service';

import servicePokemonFixture from '../fixtures/servicePokemonFixture.json';

describe('PokemonService', () => {
  let service: PokemonService;
  let httpMock: HttpTestingController;
  let mockPokemonId = servicePokemonFixture.pokeId;
  let mockSpritesFiltered = servicePokemonFixture.spritesFiltered;
  let mockTypes = [servicePokemonFixture.pokemon.types[0].type.name];
  let mockMoves = [
    servicePokemonFixture.pokemon.moves[0].move.name,
    servicePokemonFixture.pokemon.moves[1].move.name,
    servicePokemonFixture.pokemon.moves[2].move.name
  ];
  let mockPokemonData = servicePokemonFixture.pokemon;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PokemonService]
    });
    service = TestBed.inject(PokemonService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => httpMock.verify());

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should make http requests to the PokeAPI with pokemon id and get back expected result', () => {
    /**
     * What is happening here?
     *  1. the service makes a normal method call (getPokemon, in this case)
     *  2. getPokemon makes an http request to the PokeApi, but since we are using the http test controller
     *     the request is intercepted
     *  3. the mock's method "expectOne" checks if the expected request was made, failing the test if it was
     *     not. We also check the proper method was used
     *  4. the "flush" method is used to return an http response
     *  5. since we subscribed to the observable of the "getPokemon" method the callback function is triggered
     *     and we can check that we get back the expected return value
     *
     * since we control the return value there should be no surprises there, but for this test we are more
     * concerned with actually making an http request with the right data to the correct location
     */
    service.getPokemon(mockPokemonId).subscribe(data => {
      expect(data).toEqual(mockPokemonData);
    });
    const request = httpMock.expectOne(`https://pokeapi.co/api/v2/pokemon/${mockPokemonId}`);
    expect(request.request.method).toEqual('GET');
    request.flush(mockPokemonData);
  });

  it('should pass the pokemon data through the various update methods', () => {
    const funcSpys = [
      spyOn(service, 'setPokemonName').and.stub(),
      spyOn(service, 'setPokemonSprites').and.stub(),
      spyOn(service, 'setPokemonTypes').and.stub(),
      spyOn(service, 'setPokemonMoves').and.stub(),
    ];
    const subjectSpy = spyOn(service.pokemonSubject, 'next').and.stub();

    service.updatePokemon(mockPokemonData);

    for(let spy of funcSpys){
      expect(spy).toHaveBeenCalledWith(mockPokemonData);
    }
    expect(subjectSpy).toHaveBeenCalledWith(service.pokemon);

  });

  it('should update the pokemon property name when setPokemonName is called', () =>{
    service.setPokemonName(mockPokemonData);
    /**
     * The expect below is simialr to service.pokemon.name === mockPokemonData.name
     */
    expect(service.pokemon.name).toBe(mockPokemonData.name);
  });

  it('should update the pokemon property sprites when setPokemonSprites is called', () =>  {
    service.setPokemonSprites(mockPokemonData);
    /**
     * the expect below is similar to using an equals method on the values: checks properties and values.
     * Using the "toBe" method here would fail the test
     */
    expect(service.pokemon.sprites).toEqual(mockSpritesFiltered);
  });

  it('should update the pokemon property types when setPokemonTypes is called', () => {
    service.setPokemonTypes(mockPokemonData);
    expect(service.pokemon.types).toEqual(mockTypes);
  });

    it('should update the pokemon property moves when setPokemonTypes is called', () => {
      service.setPokemonMoves(mockPokemonData);
      expect(service.pokemon.moves).toEqual(mockMoves);
    });
});

