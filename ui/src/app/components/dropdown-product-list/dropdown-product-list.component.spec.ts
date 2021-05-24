import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropdownProductListComponent } from './dropdown-product-list.component';

describe('DropdownProductListComponent', () => {
  let component: DropdownProductListComponent;
  let fixture: ComponentFixture<DropdownProductListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropdownProductListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropdownProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
