import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactusclickComponent } from './contactusclick.component';

describe('ContactusclickComponent', () => {
  let component: ContactusclickComponent;
  let fixture: ComponentFixture<ContactusclickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactusclickComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactusclickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
