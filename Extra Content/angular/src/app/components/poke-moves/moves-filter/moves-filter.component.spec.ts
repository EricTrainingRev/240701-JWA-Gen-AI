import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovesFilterComponent } from './moves-filter.component';

describe('MovesFilterComponent', () => {
  let component: MovesFilterComponent;
  let fixture: ComponentFixture<MovesFilterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MovesFilterComponent]
    });
    fixture = TestBed.createComponent(MovesFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
