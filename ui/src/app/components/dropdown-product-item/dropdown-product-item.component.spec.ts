import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropdownProductItemComponent } from './dropdown-product-item.component';

describe('DropdownProductItemComponent', () => {
  let component: DropdownProductItemComponent;
  let fixture: ComponentFixture<DropdownProductItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropdownProductItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropdownProductItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
