import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredClaimComponent } from './registered-claim.component';

describe('RegisteredClaimComponent', () => {
  let component: RegisteredClaimComponent;
  let fixture: ComponentFixture<RegisteredClaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredClaimComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteredClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
