import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutusclickComponent } from './aboutusclick.component';

describe('AboutusclickComponent', () => {
  let component: AboutusclickComponent;
  let fixture: ComponentFixture<AboutusclickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutusclickComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutusclickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
