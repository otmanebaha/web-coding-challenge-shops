import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPreferredShopsComponent } from './my-preferred-shops.component';

describe('MyPreferredShopsComponent', () => {
  let component: MyPreferredShopsComponent;
  let fixture: ComponentFixture<MyPreferredShopsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyPreferredShopsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPreferredShopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
