import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ARPlansComponent } from './a-r-plans.component';

describe('ARPlansComponent', () => {
  let component: ARPlansComponent;
  let fixture: ComponentFixture<ARPlansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ARPlansComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ARPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
