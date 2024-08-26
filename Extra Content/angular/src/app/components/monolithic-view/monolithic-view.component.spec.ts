import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonolithicViewComponent } from './monolithic-view.component';

describe('MonolithicViewComponent', () => {
  let component: MonolithicViewComponent;
  let fixture: ComponentFixture<MonolithicViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MonolithicViewComponent]
    });
    fixture = TestBed.createComponent(MonolithicViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
