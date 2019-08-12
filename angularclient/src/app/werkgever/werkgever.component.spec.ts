import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WerkgeverComponent } from './werkgever.component';

describe('WerkgeverComponent', () => {
  let component: WerkgeverComponent;
  let fixture: ComponentFixture<WerkgeverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WerkgeverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WerkgeverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
