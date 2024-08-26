import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';

import { SearchComponent } from './search.component';
import { PokemonService } from 'src/app/services/pokemon.service';
import { Observable } from 'rxjs';
import { Pokemon } from 'src/app/interfaces/pokemon';

/**
 * This block groups together related tests for the `SearchComponent`.
 */
describe('SearchComponent Tests', () => {
  /**
   * This variable will be used to reference an instance of the `SearchComponent` class.
   */
  let component: SearchComponent;
  /**
   * This variable will be used to reference a fixture that wraps the `SearchComponent` instance.
   */
  let fixture: ComponentFixture<SearchComponent>;
  /**
   * This variable will be used to reference a mock version of the `PokemonService`.
   */
  let pokemonServiceSpy: jasmine.SpyObj<PokemonService>;

  /**
   * This block sets up the component and its dependencies before each test is run.
   */
  beforeEach(() => {
    /**
     * This line creates a mock version of the `PokemonService` using Jasmine's `createSpyObj` function.
     * Note that we register the methods we are spying on
     */
    const spy = jasmine.createSpyObj('PokemonService', [
      'getPokemon',
      'updatePokemon',
    ]);

    TestBed.configureTestingModule({
      /**
       * This line declares the `SearchComponent` as a part of the testing module.
       */
      declarations: [SearchComponent],

      /**
       * This line imports the necessary modules for testing the component.
       */
      imports: [/*HttpClientTestingModule*/ FormsModule],

      /**
       * This line provides the mock service as a provider for the testing module.
       */
      providers: [
        {
          provide: PokemonService,
          useValue: spy,
        },
      ],
    });

    /**
     * This line creates a fixture that wraps an instance of the `SearchComponent`.
     */
    fixture = TestBed.createComponent(SearchComponent);

    /**
     * This line assigns the component instance to a variable called `component`.
     */
    component = fixture.componentInstance;

    /**
     * This line injects the mock service into the component instance.
     */
    pokemonServiceSpy = TestBed.inject(
      PokemonService
    ) as jasmine.SpyObj<PokemonService>;

    /**
     * This line detects changes to the component's state and updates the view accordingly.
     */
    fixture.detectChanges();
  });

  /**
   * This test case checks if the component was created successfully.
   */
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  /**
   * This test case checks if the component calls the `getPokemon` and `updatePokemon` methods of the
   * mock service correctly.
   */
  it('should call getPokemon and updatePokemon', () => {
    /**
     * This object represents a mock Pokemon object.
     */
    const mockPokemon: Pokemon = {
      name: 'pikachu',
      sprites: ['source-one', 'source-two'],
      types: ['electric'],
      moves: ['thunderbolt', 'thunder', 'mega-punch'],
    };

    /**
     * This line sets up a mock return value for the `getPokemon` method of the mock service.
     */
    pokemonServiceSpy.getPokemon.and.returnValue(new Observable<Object>());

    /**
     * This line sets up a search query for a Pokemon with ID 25.
     */
    component.pokeId = '25';

    /**
     * This line invokes the `searchPokemon` method of the component.
     */
    component.searchPokemon();

    /**
     * This line checks if the `getPokemon` method of the mock service was called with ID 25.
     */
    expect(pokemonServiceSpy.getPokemon).toHaveBeenCalledWith('25');

    /**
     * This line waits for all asynchronous tasks to complete before checking if the `updatePokemon`
     * method of the mock service was called with the expected Pokemon object.
     */
    fixture.whenStable().then(() => {
      expect(pokemonServiceSpy.updatePokemon).toHaveBeenCalledWith(mockPokemon);
    });
  });
});
