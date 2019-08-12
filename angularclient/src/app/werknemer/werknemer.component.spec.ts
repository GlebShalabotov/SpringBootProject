import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WerknemerComponent } from './werknemer.component';

describe('WerknemerComponent', () => {
  let component: WerknemerComponent;
  let fixture: ComponentFixture<WerknemerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WerknemerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WerknemerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
