import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleBuyPlanComponent } from './single-buy-plan.component';

describe('SingleBuyPlanComponent', () => {
  let component: SingleBuyPlanComponent;
  let fixture: ComponentFixture<SingleBuyPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleBuyPlanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleBuyPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
